# Write your MySQL query statement below
(SELECT u.name as results
FROM users u
LEFT JOIN MovieRating mr
on u.user_id = mr.user_id
Group by u.user_id
Order by count(mr.user_id) desc , u.name
limit 1)
UNION all
(SELECT m.title as results
FROM movies m
LEFT JOIN MovieRating mr
on m.movie_id = mr.movie_id
where extract(year_month from created_at) = 202002
Group by m.movie_id
Order by avg(mr.rating) desc , m.title
limit 1)
