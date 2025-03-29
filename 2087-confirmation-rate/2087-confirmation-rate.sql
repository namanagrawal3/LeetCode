# Write your MySQL query statement below

SELECT user_id, IFNULL(ROUND(SUM(action = 'confirmed')/COUNT(*), 2), 0.00) AS confirmation_rate
FROM Signups s LEFT JOIN Confirmations c USING(user_id)
GROUP BY s.user_id;
