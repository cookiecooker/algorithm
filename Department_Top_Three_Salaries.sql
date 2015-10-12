# Write your MySQL query statement below
select d.Name as Department,
ee.Name as Employee,
ee.Salary as Salary
from Department d, (
  select * from Employee e
  where (select count(distinct Salary) from Employee
            where DepartmentId = e.DepartmentId
            and Salary > e.Salary) < 3 
) ee
where ee.DepartmentId = d.Id
order by d.name, ee.Salary;
