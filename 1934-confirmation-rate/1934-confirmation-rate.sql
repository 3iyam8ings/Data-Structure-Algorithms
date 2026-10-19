# Write your MySQL query statement below
SELECT s.user_id , 
round(avg( if(c.action= 'confirmed', 1, 0)), 2) as confirmation_rate
FROM signups s
LEFT JOIN confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id