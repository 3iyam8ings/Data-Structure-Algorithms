# Write your MySQL query statement below
SELECT p.product_name , sum(o.unit) as unit
from products p
LEFT JOIN orders o
ON o.product_id = p.product_id
WHERE extract(year_month from o.order_date) = 202002
GROUP BY p.product_name 
HAVING sum(o.unit) >=100 