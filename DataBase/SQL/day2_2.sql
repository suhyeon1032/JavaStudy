use demo;
show tables;

select * from emp;
select * from dept;
select * from salgrade;
desc emp;


select count(empno) from emp;
select count(comm) from emp;
select count(ename) from emp;
select max(sal), min(sal), avg(sal), sum(sal) from emp;
select * from salgrade;
select max(sal), min(sal), avg(sal), sum(sal) from emp;
-- 부서별 사원수, 급여합계, 급여 평균을 구하라
-- 그룹함수를 사용하는 필드와 사용하지 않는 필드는 함께 표기할 수 없다.
-- 단 분류기준은 사용할 수 있다.
select deptno, count(ename), sum(sal), avg(sal) from emp group by deptno
order by deptno;
-- 업무별 통계
select job, count(empno), sum(sal), max(sal), avg(sal), min(sal)
from emp group by job;

select distinct job from emp; -- 중복데이터 제거

-- 업무별 급여의 합계, 평균을 구하여 평균이 3000불이상인 업무를 출력하라.
select job, sum(sal), avg(sal) from emp 
group by job
having avg(sal)>=3000;
-- 업무별 급여 평균고 보너스(comm)의 평균을 구하라
select job, avg(sal), avg(comm) from emp group by job;
-- null 데이터 계산에서 제외된다.
select sum(sal), avg(sal), sum(comm), avh(comm) from emp;
select ename, sal, comm, ifnull(comm,0) +1000 from emp;
select * from emp where comm is not null;

-- 전체 월급이 5000을 초과하는 각 업무에 대해서 업무와 월급여 합계를 출력하라.
-- 단 판매원은 제외하고 월 급여 합계로 내침차순 정렬 하여라.
select job, sum(sal) from emp
where job!='salesman'
group by job
having sum(sal)>5000
order by sum(sal) desc;
show tables;
select * from emp;

SELECT empno, ename, hiredate, sal FROM emp ORDER BY ename asc;
