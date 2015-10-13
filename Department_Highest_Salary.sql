# Write your MySQL query statement below
select d.Name Department, e1.Name Employee, e1.Salary from Department d, Employee e1,
(select max(Salary) Salary, DepartmentId from Employee group by DepartmentId) e2
where d.Id = e2.DepartmentId
and e1.Salary = e2.Salary
and e1.DepartmentId = e2.DepartmentId;
