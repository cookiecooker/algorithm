# Write your MySQL query statement below
select s.Score, count(Ranking.Score) as Rank
from Scores s , ( select distinct Score from Scores ) Ranking
where s.Score <= Ranking.Score
group by s.Id
order by s.Score desc;
