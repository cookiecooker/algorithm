# Write your MySQL query statement below
select distinct a.Email from Person a join Person b 
on (a.Email = b.Email) and (a.Id <> b.Id);
