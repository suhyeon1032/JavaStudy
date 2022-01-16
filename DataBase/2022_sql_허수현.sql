show databases;
use employees;
show tables;
select * from employees;

-- 1. EMPLOYEES테이블의 레코드 중 사원번호, 사원명, 입사일, 성별을 선택하라.
select emp_no, first_name, gender, hire_date from employees;

-- 2. EMPLOYEES테이블의 레코드 중 사원번호, 사원명, 입사일을 선택하라.
-- (단, 사원명을 오름차순으로 정렬하여 선택)
select emp_no, first_name, hire_date from employees order by first_name asc;

-- 3. EMPLOYEES테이블의 레코드 중 6월, 12월에 입사한 사원의 사원번호, 사원명, 입사일을 선택하라.
select hire_date, emp_no, first_name from employees where hire_date like '%____06__%' || hire_date like '%____12__%';

-- 4. EMPLOYEES테이블의 레코드 중 사원명에 ‘A’로 시작하고 생일이 1950년~1959년 사이인 사원을 나이가 많은 순으로 선택하라.
select * from employees where first_name like 'A%' && birth_date like '%195_____%' order by birth_date asc;

-- 5. EMPLOYEES테이블의 레코드 중 1960년도에 태어난 남자사원을 선택하라.
select * from employees where birth_date like '196_____%' && gender like 'M';

-- 6. EMPLOYEES테이블의 사원 중 1월에 태어난 여자 사원을 이름을 오름차순으로 선택하라.
select * from employees where birth_date like '%____01__%' && gender like 'F' order by first_name asc;

-- 7. EMP테이블의 사원 입사일이 1990-01-01이후인 사원과 이름에 B가 포함된 사원을 입사일 기준 내림차순으로 정렬하여 선택하라.
select * from employees where hire_date like '190001__%' || first_name like '%B%' order by hire_date desc;

-- 8. 현재 데이터베이스의 테이블 목록을 확인하는 쿼리문을 작성하라.
show tables;

-- 9. EMPLOYEES테이블의 사원 중 사원번호, 이름, 생년월일, 입사일을 이름은 오름차순, 사원번호는 내림차순으로 정렬하여 선택하라
select emp_no, first_name, birth_date, hire_date from employees order by first_name asc, emp_no desc;

-- 10. EMPLOYEES테이블의 구조를 확인하는 쿼리문을 작성하라.
desc employees;

-- 11. 현재 계정의 데이터베이스의 목록을 확인하는 쿼리문을 작성하라.
show databases;