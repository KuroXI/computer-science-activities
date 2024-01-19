--SQL SCRIPT 1: Create a view that counts the number of hires for each month.
--Sort the list by year then by month with its number of hires.
CREATE VIEW MonthlyHires AS SELECT * FROM (
	SELECT
		EXTRACT(YEAR FROM e.hireDate) AS hire_year,
		EXTRACT(MONTH FROM e.hireDate) AS hire_month,
		COUNT(*) AS hire_count
	FROM employee e
	GROUP BY YEAR(e.hireDate), MONTH(e.hireDate)
	ORDER BY hire_year, hire_month
) mh;
	
SELECT * FROM MonthlyHires;

--SQL SCRIPT 2: Formulate a view that counts that number of sales transactions a customer has entered.
--You must display the customer number, customer name, and the total number of sales transactions.
--Sort the list from highest to lowest count.
CREATE VIEW CustomerTransaction AS SELECT * FROM (
	SELECT c.custNo, c.custName, COUNT(s.transNo) AS transactionCount
	FROM customer c
	LEFT JOIN sales s ON c.custNo = s.custNo
	GROUP BY c.custNo, c.custName
	ORDER BY transactionCount DESC
) ct;

SELECT * FROM CustomerTransaction;

--SQL SCRIPT 3: What is the average salary of  each job position?
--Exclude manager, vice president, and president from the generated list.
--Your view must display the job code, job description, and the average salary of each job.
CREATE VIEW AverageSalary AS
SELECT j.jobCode, j.jobDesc, AVG(jh.salary) AS averageSalary
FROM job j
LEFT JOIN jobHistory jh ON j.jobCode = jh.jobCode
WHERE j.jobDesc NOT IN ('Manager', 'Vice President', 'President')
GROUP BY j.jobCode, j.jobDesc;

SELECT * FROM AverageSalary;

--SQL SCRIPT 4: Design a view will determine products that have undergone price changes.
--Sort the list from highest to lowest count which also displays the product code and product description.
--Exclude products that have no price change.
CREATE VIEW PriceChange AS SELECT * FROM (
	SELECT p.prodCode, p.description, COUNT(ph.unitPrice) AS changesCount
	FROM product p
	LEFT JOIN priceHist ph ON p.prodCode = ph.prodCode
	GROUP BY p.prodCode, p.description
	HAVING COUNT(DISTINCT ph.unitPrice) > 1
	ORDER BY changesCount DESC
) pc;

SELECT * FROM PriceChange;

--SQL SCRIPT 5: What is the current price of each product?
--Create a view that displays the product code, product description, unit, and its current price.
CREATE VIEW CurrentProductPrice AS
SELECT p.prodCode, p.description, p.unit, MAX(ph.unitPrice) AS currentPrice
FROM product p
LEFT JOIN priceHist ph ON p.prodCode = ph.prodCode
GROUP BY p.prodCode, p.description, p.unit;

SELECT * FROM CurrentProductPrice;

--SQL SCRIPT 6: Determine the current number of employees per each department.
--Your view should contain the department code, department name, and the number of employees a department has.
--Do not include separated (with SEPDATE values) employees.
CREATE VIEW EmployeeDepartmentCount AS
SELECT d.deptName, jh.deptCode, COUNT(e.hireDate) AS employeeCount
FROM department d
LEFT JOIN jobHistory jh ON d.deptCode = jh.deptCode
LEFT JOIN employee e ON jh.empNo = e.empNo
WHERE e.sepDate IS NULL
GROUP BY d.deptName, jh.deptCode, e.sepDate;

SELECT * FROM EmployeeDepartmentCount;

--SQL SCRIPT 7: Who among the employees received the most number of promotions?
--The view must contain the employee number, employee name (combined last name and first name).
--Sort the list with the most number of promotions. Do not include separated employees. 
CREATE VIEW EmployeePromotionCount AS SELECT * FROM (
	SELECT e.empNo, e.lastName || ', ' || e.firstName AS employeeName, COUNT(jh.effDate) AS promotionCount
	FROM employee e
	LEFT JOIN jobHistory jh ON e.empNo = jh.empNo
	WHERE e.sepDate IS NULL
	GROUP BY e.empNo, e.lastName || ', ' || e.firstName, e.sepDate
	ORDER BY promotionCount DESC
) epc;

SELECT * FROM EmployeePromotionCount;

--SQL SCRIPT 8: What is the most bought product of the company?
--Your view must list the highest to lowest including the product code,
--product description, and unit, total_quantity.
CREATE VIEW MostBoughtProduct AS SELECT * FROM (
	SELECT p.prodCode, p.description, p.unit, SUM(sd.quantity) AS totalQuantity
	FROM product p
	JOIN salesDetail sd ON p.prodCode = sd.prodCode
	GROUP BY p.prodCode, p.description, p.unit
	ORDER BY totalQuantity DESC
) mbp;

SELECT * FROM MostBoughtProduct;

--SQL SCRIPT 9: What is the total sales of each product?
--Your view must contain product code, description, unit, total sales.
CREATE VIEW FilterSalesDate AS
SELECT sd.transNo, s.salesDate, ph.effDate as effDate, sd.prodCode, sd.quantity
FROM salesDetail sd
JOIN sales s ON sd.transNo = s.transNo
JOIN priceHist ph ON sd.prodCode = ph.prodCode
WHERE s.salesDate >= ph.effDate;

CREATE VIEW EffectiveDate AS
SELECT fsd.prodCode, MAX(effDate) AS maxEffDate
FROM FilterSalesDate fsd
GROUP BY fsd.prodCode;

CREATE VIEW TotalProductSales AS SELECT * FROM (
	SELECT p.prodCode, p.description, p.unit, SUM(fsd.quantity * ph.unitPrice) AS totalSales
	FROM product p
	JOIN EffectiveDate ed ON p.prodCode = ed.prodCode
	JOIN FilterSalesDate fsd ON fsd.prodCode = ed.prodCode AND fsd.effDate = ed.maxEffDate
	JOIN priceHist ph ON fsd.prodCode = ph.prodCode AND fsd.effDate = ph.effDate
	GROUP BY p.prodCode, p.description, p.unit
) tps;

SELECT * FROM TotalProductSales;

--SQL SCRIPT 10: Who is the customer that contributed the sales of the company?
--Sort your list from highest to lowest including the customer code, name, and its total sales.
CREATE VIEW FilterCustomerContribute AS
SELECT s.custNo, sd.transNo, sd.quantity, ph.effDate AS effDate, sd.prodCode
FROM sales s
JOIN salesDetail sd ON s.transNo = sd.transNo
JOIN priceHist ph ON sd.prodCode = ph.prodCode
WHERE s.salesDate >= ph.effDate;

CREATE VIEW EffectiveDateCustomerContribute AS
SELECT fcc.custNo, MAX(fcc.effDate) AS maxEffDate
FROM FilterCustomerContribute fcc
GROUP BY fcc.custNo, fcc.transNo;

CREATE VIEW TotalCustomerContribute AS SELECT * FROM (
	SELECT c.custNo, c.custName, SUM(fcc.quantity * ph.unitPrice) AS totalContribute
	FROM customer c
	JOIN EffectiveDateCustomerContribute edcc ON c.custNo = edcc.custNo
	JOIN FilterCustomerContribute fcc ON fcc.custNo = edcc.custNo AND fcc.effDate = edcc.maxEffDate
	JOIN priceHist ph ON fcc.prodCode = ph.prodCode AND fcc.effDate = ph.effDate
	GROUP BY c.custNo, c.custName
) tcc;

SELECT * FROM TotalCustomerContribute;