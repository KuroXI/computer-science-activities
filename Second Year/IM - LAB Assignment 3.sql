--SQL Script 1: List employee number, last name, first name, middle initial
--where middle initial of employee's name  is null. 
SELECT LASTNAME, FIRSTNME, MIDINIT FROM EMP WHERE MIDINIT IS NULL;

--SQL Script 2:  List  lastname, first name and birthdate sorted by last name. 
--Concatenate last name with comma-space and first name, respectively. 
--Use alias name "Name" as the column name of the concatenated names. 
SELECT LASTNAME || ', ' || FIRSTNME AS "NAME", BIRTHDATE FROM EMP ORDER BY 1;

--SQL Script 3: Display employee number, last name, first name, hire date of all employees
--which were hired between 1990 and 2000.  Sort results by hiredate.
SELECT EMPNO, LASTNAME, FIRSTNME, HIREDATE FROM EMP
WHERE HIREDATE BETWEEN '1990-1-1' AND '2000-1-1' ORDER BY HIREDATE ASC;

--SQL Script 4: Display work dept, last name, first name, salary sorted by work dept and last name
--filtered with salary ranging from 30,000 and 50,000. 
SELECT WORKDEPT, LASTNAME, FIRSTNME, SALARY FROM EMP 
WHERE SALARY BETWEEN 30000 AND 50000 ORDER BY WORKDEPT, LASTNAME;

--SQL Script 5: Display work dept, employee number,  name( concatenated by last name, first name), 
--salary, salary with 10% increase.  Label the salary with 10% increase as "New Salary".
--Only salaries ranging from 35000 and 40000 are entitled for the increase.
--Sort according to workdept and lastname. 
SELECT
	WORKDEPT,
	EMPNO,
	LASTNAME || ', ' || FIRSTNME AS "NAME",
	SALARY, SALARY + CAST((SALARY * 0.10) AS DECIMAL(9, 2)) AS "New Salary"
FROM EMP WHERE SALARY BETWEEN 35000 AND 40000 ORDER BY WORKDEPT, LASTNAME;
