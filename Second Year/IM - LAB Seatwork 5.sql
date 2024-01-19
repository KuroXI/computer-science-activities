--Display employee number, concatenated last name and first name, and work dept.
--On top of the employees is the boss of the department.
--The output will somewhat  with semblance below: (25 points)
CREATE VIEW boss_employee_view AS SELECT * FROM (
	SELECT empNo,
		CASE WHEN job IN ('PRES', 'MANAGER')
			THEN '== BOSS NAME: ' || lastName || ', ' || firstNme
			ELSE lastName || ', ' || firstNme
		END AS empName
	, job, workDept
	FROM emp
	ORDER BY workDept
);

SELECT * FROM boss_employee_view;

--What department has the biggest total salary of employees?
--Your output should consist of department number, department name, and its total salary of employees.
--Include all departments even if it has no employees. (25 points)
CREATE VIEW total_salary_department_view AS SELECT * FROM (
	SELECT d.deptNo, d.deptName, SUM(e.salary) AS TotalSalary
	FROM dept d
	LEFT JOIN emp e ON d.deptNo = e.workDept
	GROUP BY d.deptNo, d.deptName
	ORDER BY 3 DESC
);

SELECT * FROM total_salary_department_view;

--What are the projects per department?
--Your result should include department number, department name, project number, project name, responsible employee number, name of responsible employee.
--Do not include a department that has no projects. (25 points)
CREATE VIEW project_department_view AS SELECT * FROM (
	SELECT d.deptNo, d.deptName, p.projNo, p.projName, p.respEmp, e.lastName
	FROM dept d
	LEFT JOIN project p ON d.deptNo = p.deptNo
	LEFT JOIN emp e ON p.respEmp = e.empNo
	WHERE p.projNo IS NOT NULL
	ORDER BY p.projName
);

SELECT * FROM project_department_view;

--How many hours an employee spent on a project?
--Your output should include, employee number, last name, first name, project number, project name, total employee time.
--Do not include president and managers of the company and employees who have no projects. Sort according to employee number. (25 points)
CREATE VIEW employee_spent_view AS SELECT * FROM (
	SELECT epa.empNo, e.lastName, e.firstNme, epa.projNo, p.projName, SUM(epa.empTime) AS TotalTime
	FROM empProjAct epa
	LEFT JOIN project p ON p.projNo = epa.projNo
	LEFT JOIN emp e ON epa.empNo = e.empNo
	WHERE e.job NOT IN ('PRES', 'MANAGER')
	GROUP BY epa.empNo, e.lastName, e.firstNme, epa.projNo, p.projName
);

SELECT * FROM employee_spent_view;