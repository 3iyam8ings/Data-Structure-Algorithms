# Write your MySQL query statement below
SELECT department , employee , salary from
(SELECT d.name as Department , e.name as Employee , e.salary as Salary ,
dense_rank() over(partition by d.name order by e.salary desc ) as ranks
FROM Employee e
LEFT JOIN department d
ON e.departmentID = d.id) temp
where ranks <= 3