# Write your MySQL query statement below
SELECT max(num) as num from (SELECT num
from myNumbers
GROUP BY num
HAVING count(num) = 1) as new_table