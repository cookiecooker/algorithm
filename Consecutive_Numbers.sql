# Write your MySQL query statement below
select distinct NUM from ( # the same number may appear after

  select NUM, @count := if(@preNum = NUM, @count + 1, 1) as cnt, @preNum := NUM 
  from Logs, (select @preNum := NULL) pn, (select @count := 0) ct
  #order by Id asc
)t

where cnt >= 3;
