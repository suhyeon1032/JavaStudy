-- 데이터베이스목록
show databases;
-- 데이터베이스 선택
use employees;
-- 테이블 목록 확인
show tables;
-- 레코드 선택
select * from employees;

-- 숫자함수
select abs(-100);
select abs(emp_no-400000) '절대치' from employees;
select ceil(10.1), ceil(-10.1), floor(10.9), floor(-10.9);
select round(192.123, 1), round(192.123, -1);