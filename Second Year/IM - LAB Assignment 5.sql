--SQL SCRIPT 1: List the transaction number, sales date, product code, description, unit and quantity from the hope database.
--Sort according to transaction number and product code. Use LEFT JOIN in your solution.
SELECT sd.transNo, sd.prodCode, p.description, p.unit, sd.quantity
FROM salesDetail sd
LEFT JOIN product p ON sd.prodcode = p.prodcode
ORDER BY sd.transNo, sd.prodCode;

--SQL SCRIPT 2: Display the employee number, last name, first name, job description, and effectivity date
--from the job history of the employee. Sort last name and effectivity date (last date first). Use LEFT JOIN.
SELECT emp.empNo, emp.lastName, emp.firstName, j.jobDesc, jh.effDate
FROM employee emp
LEFT JOIN jobHistory jh ON emp.empNo = jh.empNo
LEFT JOIN job j ON j.jobCode = jh.jobCode
ORDER BY emp.lastName, jh.effDate DESC;

--SQL SCRIPT 3: Show total quantity sold from product table. Display product code, description, unit, quantity.
--Use RIGHT JOIN.  Sort according to the most product sold.
SELECT p.prodCode, p.description, p.unit, SUM(sd.quantity) AS totalQuantity
FROM product p
RIGHT JOIN salesDetail sd ON p.prodCode = sd.prodCode
GROUP BY p.prodCode, p.description, p.unit
ORDER BY totalQuantity DESC;

--SQL SCRIPT 4:  Generate the detailed payments made by customers for specific transactions.
--Display customer number, customer name, payment date, official receipt no, transaction number and payment amount.
--Sort according to the customer name. Use LEFT JOIN.
SELECT c.custNo, c.custName, p.payDate, p.ORNo, s.transNo, p.amount
FROM customer c
LEFT JOIN sales s ON s.custNo = c.custNo
LEFT JOIN payment p ON p.transNo = s.transNo
ORDER BY c.custName;

--SQL SCRIPT 5:  What is the current price of each product?
--Display product code, product description, unit, and its current price.
--Always assume that NOT ALL products HAVE unit price BUT you need to
--display it even if it has no unit price on it. DO NOT USE INNER JOIN.
SELECT p.prodCode, p.description, p.unit, ph.unitPrice AS currentPrice
FROM product p
FULL JOIN priceHist ph ON p.prodCode = ph.prodCode
WHERE (ph.prodCode, ph.effDate) IN (
	SELECT prodCode, MAX(effDate) FROM priceHist GROUP BY prodCode
);