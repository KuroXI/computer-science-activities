CREATE VIEW department_report_view AS SELECT * FROM (
	SELECT e.empNo, e.lastName, e.firstName, j.jobDesc, jh.salary, d.deptname
	FROM employee e
	LEFT JOIN (
	    SELECT empNo, MAX(effDate) AS effDate
	    FROM jobHistory
	    GROUP BY empNo
	) latestEmpJob ON e.empNo = latestEmpJob.empNo
	LEFT JOIN jobHistory jh ON e.empNo = jh.empNo AND jh.effDate = latestEmpJob.effDate
	LEFT JOIN job j ON jh.jobCode = j.jobCode
	LEFT JOIN department d ON jh.deptCode = d.deptCode
	WHERE e.sepDate IS NULL
	ORDER BY d.deptName, e.lastName
);