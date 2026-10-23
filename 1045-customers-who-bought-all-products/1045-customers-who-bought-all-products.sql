# Write your MySQL query statement below
SELECT customer_id 
FROM customer
GROUP BY customer_id
HAVING count( distinct product_key) = (SELECT count(product_key) FROM product)