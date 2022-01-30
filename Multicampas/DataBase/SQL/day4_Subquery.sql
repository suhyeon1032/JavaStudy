use demo;
select * from emp;
-- 서브쿼리
select * from emp where sal>(select avg(sal) from emp);
-- emp테이블의급여 jones의 급여보다 많이 받는 사원중 부서가 30번 부서인 사원을 선택하라.
select * from emp where sal>(select sal from emp where ename='jones') and deptno=20;

-- 담당업무가 manager 업무를 하는 사원의 평균 급여보다 작게 받는 사원을 선택하라.
select * from emp where sal<(select avg(sal) from emp where job='manager');
-- [문제1] 사원테이블에서 사원명, 입사일, 담당업무, 부서코드를 선택하되 ‘ADAMS’와 
-- 같은 업무를 하는 사원이거나 ‘SCOTT’과 같은 부서인 사원을 선택하라.
select ename, hiredate, job, deptno from emp
where job=(select job from emp where ename='adams')
or DEPTNO=(select DEPTNO from emp where ename='scott');
-- [문제2] 사원테이블에서 사원번호가 7521인 사원과 업무가 같고 급여가 7934인 사원보다
-- 많은 급여를 받는 사원의 사번,이름,업무,입사일자,급여를 출력하세요.
select * from emp;
select empno, ename, job, hiredate, sal from emp
where job = (select job from emp where empno=7521) 
and sal>(select sal from emp where empno=7934);

-- [실습] 사원테이블에서 사원의 급여가 20번부서의 최소급여보다 많이 받는 부서를 선택하라.
select deptno, min(sal) from emp group by deptno;

select deptno, min(sal) from emp 
group by DEPTNO 
having min(sal)>(select min(sal) from emp where deptno=30);

-- [문제1] 사원테이블의 사원의 급여가 10번부서의 평균급여보다 많이 받는 업무를 하는 업무별 평균급여를 선택하라.

select avg(sal) from emp where drptno=10;
select job, avg(sal) from emp group by job
having avg(sal)>(select avg(sal) from emp where deptno=10);

-- 다중 행 서브 쿼리 5000, 3000, 2850
select max(sal) from emp group by deptno;
-- 부서별 최고 급여와 같은 급여를 받는 사원
select ename, job, deptno, sal from emp 
where sal not in (select max(sal) from emp group by deptno);

-- [문제] 업무별로 최대 급여를 받는 사원과 같은 급여를 받는 사원의 사원번호와 이름, 업무, 급여을 출력하세요.
select empno, ename, job, sal from emp 
where sal in (select max(sal) from emp group by job);

select * from emp
where deptno != 20
and sal>any(select sal from emp where job='salesman'); -- select sal from emp where job='salesman'이렇게 실행하면 다중행이어서 실행 안됨 앞에 any 넣어줘야한다.

-- [문제] 사원테이블의 사원중 KING속한 부서의 사원보다 늦게 입사한 사원의 사원명, 업무, 급여, 입사일을 선택하라.
-- 1981-06-09
select ename, job, sal, hiredate from emp 
where hiredate>any(select hiredate from emp 
					where deptno=(select deptno from emp where ename='king'));

-- all :  모든 데이터가 만족하여야 한다.
select * from emp
where sal>all(select sal from emp where job='salesman')
and deptno!=20;

select * from emp;

select * from emp e
where exists (select empno from emp where e.empno=mgr);
select * from emp where empno=mgr;

-- emp테이블의 사원중 사원명, 담당업무, 입사일, 급여를 선택하되
-- scott이 속한 부서의 평균급여보다 많이 받는 사원과
-- manager 업무를 하는 사원을 선택하라
-- 단, 사원명을 오름차순으로 정렬하여 출력하라. 2175
select ename, job, hiredate, sal from emp
where sal>(select avg(sal) from emp 
where deptno=(select deptno from emp where ename='scott'))
or job = 'manager' order by ename asc;

-- 30번 부서의 보너스를 받는 사원은(급여, 부서코드)?
select * from emp where 
(sal, deptno) in (select sal, deptno from emp where deptno=30 and comm is not null);

select * from emp order by job;

-- [문제]업무별로 최소 급여를 받는 사원의 사번, 이름, 업무, 부서번호를 출력하세요. 단, 업무별로 정렬하세요.

-- 업무별 최저 급여
select empno, ename, job, deptno from emp
where (job, sal) in (select job, min(sal) from emp group by job)
order by job asc;


select job, min(sal) from emp group by job;

-- from 절에 서브쿼리 문 사용하기
select e.ename, e.sal
from (select empno, ename, sal, hiredate from emp where deptno=30) e;

select empno, ename, sal, hiredate from emp;

-- 사원번호 같은 값이 들어가는지 확인하기
insert into emp(empno, ename, deptno) values (7788, 'abcd', 30);
select * from emp;

delete from emp where ename = 'abcd';

-- 제약 조건 설정 : empno primary key
alter table emp add constraint emp_pk_empno
primary key(empno);

