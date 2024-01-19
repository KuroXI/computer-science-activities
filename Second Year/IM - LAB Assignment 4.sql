SELECT payterm, COUNT (payterm) AS "Count" FROM customer
WHERE address LIKE '%CA%' GROUP BY payterm
HAVING payterm IN ('COD', '30D', '45D');

SELECT gender, COUNT (gender) AS "Count" FROM personnel
GROUP BY gender HAVING gender IN ('M', 'F');

SELECT prodCode, SUM(quantity) as "Total Quantity" FROM receiptDetail
GROUP BY prodCode ORDER BY "Total Quantity" DESC;

SELECT YEAR(payDate), transno, SUM(amount) AS "Total Payment" FROM payment
WHERE amount >= 1000
GROUP BY YEAR(payDate), transNo
ORDER BY YEAR(payDate) DESC, "Total Payment" DESC;

SELECT prodcode, COUNT(prodCode) AS "Total Change" FROM pricehist
GROUP BY prodcode HAVING COUNT(prodCode) > 1;