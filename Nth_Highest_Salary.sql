CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare m int;
set m = n - 1; # first index of the table is 0
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary from Employee order by Salary desc
      limit m,1 # limit a,b  a
  );
END
