# Write your MySQL query statement below

SELECT st.student_id, st.student_name, sj.subject_name, COUNT(e.subject_name) AS attended_exams
FROM Students st CROSS JOIN Subjects sj
LEFT JOIN Examinations e 
ON e.student_id = st.student_id AND sj.subject_name = e.subject_name
GROUP BY st.student_id, st.student_name, sj.subject_name
ORDER BY st.student_id, sj.subject_name; 
