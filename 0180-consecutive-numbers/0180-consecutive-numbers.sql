# Write your MySQL query statement below
SELECT l1.num as consecutiveNums
FROM logs l1, logs l2, logs l3
WHERE l1.id - l2.id = 1
and l2.id - l3.id = 1
and l1.num = l2.num
and l2.num = l3.num
GROUP BY l1.num