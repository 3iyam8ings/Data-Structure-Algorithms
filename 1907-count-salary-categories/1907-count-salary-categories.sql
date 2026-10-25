# Write your MySQL query statement below
SELECT "Low Salary" as category,
sum(if(income < 20000 , 1, 0)) as accounts_count
FROM accounts
UNION
SELECT "Average Salary" as category, 
sum(if(income between 20000 and 50000 , 1, 0)) as accounts_count
FROM accounts
UNION
SELECT "High Salary" as category,
sum(if(income > 50000 , 1, 0)) as accounts_count
FROM accounts
ORDER BY accounts_count DESC