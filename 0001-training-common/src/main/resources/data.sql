INSERT INTO training
(id, title, start_date_time, end_date_time, reserved, capacity) VALUES
('t01', '비즈니스 예절 교육', '2023-08-01 09:30', '2023-08-03 17:00', 1, 10)
,('t02', '자바 교육', '2023-09-01 09:30', '2023-09-03 17:00', 1, 5)
,('t03', '마케팅 교육', '2023-10-01 09:30', '2023-10-03 17:00', 5, 5)
;

INSERT INTO student_type
(id, code, name) VALUES
('st01', 'EMPLOYEE', '직장인')
,('st02', 'STUDENT', '학생')
,('st03', 'FREELANCE', '프리랜서')
;

INSERT INTO reservation
(id, training_id, student_type_id, reserved_date_time, name, phone, email_address) VALUES
('r01', 't01', 'st01', '2023-07-21', '김철수', '090-0000-0000', 'taro@example.com')
,('r02', 't01', 'st03', '2023-07-20', '한빛나', '080-0000-0000', 'jiro@example.com')
;

