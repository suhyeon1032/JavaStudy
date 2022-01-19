-- 데이터베이스목록
show databases;
-- 데이터베이스 선택
use employees;
-- 테이블 목록 확인
show tables;
-- 레코드 선택
select * from employees;

select abs(-100);
select abs(emp_no-400000) '절대치' from employees;
select ceil(10.1), ceil(-10.1), floor(-10.9), floor(-10.9);
select round(192.123, 2), round(192.123, -2), round(192.123,0);
select mod(emp_no, 4), emp_no % 4, emp_no mod 4 from employees;
-- 난수 : 0~1 사이의 값중에 1개를 무작위 생성해준다.
select rand(), ceil(rand()*100), ceil(rand()*11)+50; -- 0~99 사이의 값중에 1개가 생성된다.

-- 문자내장함수
select ascii('A'), char(65);
select char_length('가나다'), length('가나다');
select concat('김', '도현', '이다'), concat_ws(',','홍길동','김수한무','거북이');
-- employees -> first_name, last_name으로 표시할 수 있다.
select concat(first_name, last_name), concat_ws(' ', first_name, last_name) from employees;
select elt(2, 'a', 'b', 'c'), field('b', 'a', 'd', 'c'), find_in_set('b', 'a,b,c'), instr('abcd', 'b'), locate('b', 'abcd');

select insert('가나다라마바', 2, 3, '@@@');
select reverse('가나다라마바');
select left(first_name, 2), right(first_name, 2), first_name from employees;
select lcase(first_name), ucase(first_name), first_name from employees;
select lpad(first_name, 10, '*'), rpad(first_name, 10, '@'), first_name from employees;
select substring(first_name,2,3), first_name from employees;
select substring_index('daram_9.naver.com', '.', 2),
	substring_index('daram_9.naver.com', '.', -2);

--    abcdef	abc***
--    abcde	    abc**	ab***

-- first_name을 이용하여
-- 이름을 글자길이의 50%만큼 출력하고 나머지 문자는 '*'으로 표시하여라.

select rpad(substring(first_name, 1, char_length(first_name)/2), char_length(first_name),'*') as 'first_name' from employees;
select first_name, char_length(first_name) ,
	rpad( substring(first_name, 1, char_length(first_name)/2), char_length(first_name), '*') from employees;
-- 첫번째 문자만 대문자


-- ucase(), lcase() : 첫 번째 문자 대문자 나머지 소문자
select first_name, initcap(replace(ucase(first_name), 'A', '에이')) from employees;
-- goguma7day@naver.com    ->    goguma7day    naver.com
-- 날짜 내장함수
select curdate(), curtime(), now(), sysdate();
select date(now()), time(sysdate());
select year(now()), year(sysdate()), yaer(curdate());

select adddate(now(), interval 31 day);
select adddate(now(), interval 31 day);

select abs(datediff('2022-01-05', '2022-02-15'));

select dayofweek(now()), dayofyear(now());

select last_day(now()), time_to_sec(now());

select cast('2022~05~10' as date);
select cast('2022,01,26' as date);
select cast('2022-10-21' as date);
select cast(now() as date);

select date_format(now(), '%Y-%m-%d %H:%i:%S %p %W %a');

show tables;
select * from salaries;


--



