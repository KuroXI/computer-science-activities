--SQL SCRIPT 1: Create a stored procedure SHOWSTATE() that has a parameter of two-character state code ( eg. NY, CA, NJ)
--that will list  all information about the customer  who lives in a particular state. Refer to the CUSTOMER table.
--The state code can be in lower or uppercase supplied in the parameter.
--Use CA to test your stored procedure.

--#SET TERMINATOR @
CREATE PROCEDURE SHOWSTATE(IN state_code VARCHAR(2))
	DYNAMIC RESULT SETS 1
	BEGIN
		BEGIN
			DECLARE cursor_customer CURSOR WITH RETURN FOR
				SELECT *
				FROM customer
				WHERE address LIKE '%' || UPPER(state_code) || '%';
			OPEN cursor_customer;
		END;
	END @
--#SET TERMINATOR ;

CALL SHOWSTATE('CA');

--SQL SCRIPT 2: Formulate a stored procedure DISPLAYTRANS() that will display the corresponding
--sales transaction based on the transaction number passed.
--Display transaction number, sales date, product code, description, unit, quantity.
--Use TR000039 to test the output of your script.

--#SET TERMINATOR @
CREATE PROCEDURE DISPLAYTRANS(IN transaction_number VARCHAR(8))
	DYNAMIC RESULT SETS 1
	BEGIN
		BEGIN
			DECLARE cursor_transaction CURSOR WITH RETURN FOR
				SELECT s.transNo, s.salesDate, sd.prodCode, p.description, p.unit, sd.quantity
				FROM sales s
				LEFT JOIN salesDetail sd ON s.transNo = sd.transNo
				LEFT JOIN product p ON sd.prodCode = p.prodCode
				WHERE s.transNo = transaction_number;
			OPEN cursor_transaction;
		END;
	END @
--#SET TERMINATOR ;

call DISPLAYTRANS('TR000039');

--SQL SCRIPT 3: Create a user-defined function GET_TOTAL_PAYMENT() that will get the total payment made for each transaction.
--A transaction number parameter will be included when the function is called.
--Use TR000092 to test your function.

--#SET TERMINATOR @
CREATE FUNCTION GET_TOTAL_PAYMENT(IN transaction_number VARCHAR(8))
	RETURNS DECIMAL(10, 2)
	
	BEGIN ATOMIC
		DECLARE total_payment DECIMAL(10, 2);
		SET total_payment = 0.00;
		
		SET total_payment = (SELECT SUM(amount) FROM payment WHERE transNo = transaction_number);
		
		RETURN total_payment;
	END @
--#SET TERMINATOR ;

VALUES GET_TOTAL_PAYMENT('TR000092');

--SQL SCRIPT 4: Create a stored procedure PAYMENT_SHORT that will display the transaction number,
--customer name, total sales, total payment, and the difference between total sales and total payment.
--This stored procedure has no parameters.
--
--In this procedure you will use a different set of views that you have created to extract total sales
--depending on the correct unit price to be used based on effectivity date and sales date.
--
--Create these views first before using it inside your stored procedure.NO NEED TO DISPLAY THE CONTENT OF THESE VIEWS.
--To display output of the requirement, include GET_TOTAL_PAYMENT user-defined function that you have
--created in item 3. TRANSNO should serve as the parameter AND NOT TR000092.
CREATE VIEW total_sales_view AS SELECT * FROM (
	SELECT s.transNo, SUM(sd.quantity * ph.unitPrice) AS total_amount
	FROM sales s
	LEFT JOIN salesDetail sd ON s.transNo = sd.transNo
	LEFT JOIN product p ON sd.prodCode = p.prodCode
	LEFT JOIN priceHist ph ON p.prodCode = ph.prodCode
	WHERE ph.effDate = (
		SELECT MAX(ph.effDate)
		FROM priceHist ph
		WHERE ph.prodCode = p.prodCode AND ph.effDate <= s.salesDate
	)
	GROUP BY s.transNo
	ORDER BY s.transNo
);

--#SET TERMINATOR @
CREATE PROCEDURE PAYMENT_SHORT()
	DYNAMIC RESULT SETS 1
	BEGIN
		BEGIN
			DECLARE cursor_payment_short CURSOR WITH RETURN FOR
				SELECT
					s.transNo,
					c.custName,
					ts.total_amount AS total_sales,
					GET_TOTAL_PAYMENT(s.transNo) AS total_payment,
					(ts.total_amount - GET_TOTAL_PAYMENT(s.transNo)) AS difference
				FROM sales s
				LEFT JOIN customer c ON s.custNo = c.custNo
				LEFT JOIN total_sales_view ts ON s.transNo = ts.transNo
				ORDER BY s.transNo;
			OPEN cursor_payment_short;
		END;
	END @
--#SET TERMINATOR ;

CALL PAYMENT_SHORT();