# Write your MySQL query statement below
SELECT 
round(sum(if(min_order_date = min_customer_pref_delivery_date, 1, 0)*100) / count(min_order_date),2)as immediate_percentage
FROM
(SELECT delivery_id ,
 customer_id ,
 min(order_date) as  min_order_date ,
 min(customer_pref_delivery_date) as min_customer_pref_delivery_date
 FROM delivery
 GROUP BY customer_id) as new_table