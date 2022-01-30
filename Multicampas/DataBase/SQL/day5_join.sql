-- join
use demo;
select * from emp;
select * from dept;

-- 사원명(emp), 급여(emp), 부서코드(emp, dept), 부서명(dept)을 선택하라.
select emp.ename, emp.sal, emp.deptno, dept.dname -- 코드 리딩을 위해 앞에 테이블 명을 써주는게 좋다. emp. dept.
from emp, dept
where emp.deptno=dept.deptno;

select e.ename, e.sal, e.deptno, d.dname
from emp e, dept d -- 테이블 별명 지정 (코드를 짧게 하기 위함)
where e.deptno=d.deptno;

-- join문 (동등조인)
select ename, sal, emp.deptno, dname
from emp join dept
on emp.deptno=dept.deptno; -- 조인기준이 되는 필드명

select e.ename, e.sal, e.deptno, d.dname
from emp e join dept d
on e.deptno=d.deptno;

-- emp e				dept d
-- 사원번호, 담당업무, 급여, 부서명, 부서위치를 선택하라.
-- 단 30번 부서의 사원은 제외하고 급여는 10% 인상한 급여와 지급액(급여+보너스)를 출력하라.
select e.empno, e.job, e.sal*1.1 '급여', e.sal+ifnull(e.comm,0) '지급액',  d.dname, d.loc
from emp e join dept d
on e.deptno=d.deptno
where e.deptno!=30;

select a.empno, a.지급액 from
(select e.empno, e.job, e.sal*1.1 '급여', e.sal+ifnull(e.comm,0) '지급액',  d.dname, d.loc
from emp e join dept d
on e.deptno=d.deptno
where e.deptno!=30) a;

-- Manager업무를 하는 사원의 평균급여보다 많이 받는 사원을 선택하는데
-- 사원번호, 사원명, 담당업무, 급여 , 부서코드, 부서명을 사원명 오름차순으로 정렬하여 선택하라.

select e.empno, e.ename, e.job, e.sal, e.deptno, d.dname
from emp e join dept d
on e.deptno=d.deptno
and sal > (select avg(sal) from emp where job='manager') -- and 대신 where사용 가능
order by ename asc;

-- salesman의 사원번호, 이름, 급여, 부서명, 근무지를 출력하여라.
select e.empno, e.ename, e.sal, d.dname, d.loc from emp e join dept d
on e.deptno=d.deptno
where e.job='salesman';

select e.empno, e.ename, e.sal, d.dname, d.loc from emp e join dept d
on e.deptno=d.deptno
and e.job='salesman'; -- 레코드를 골라내는 조건

show tables;
select * from salgrade;

-- 비동등 조언
select e.empno, e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

select e.empno, e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e join salgrade s
where e.sal between s.losal and s.hisal;

-- emp테이블에서 사원명, 급여, 호봉을 선택하되,
-- 담당업무가 manager이거나 Salesman인 사원 중 사원명에 A가 포함된 사원을 선택하라.
select e.ename, e.job, e.sal, s.grade from emp e join salgrade s
on e.sal between losal and hisal
where e.job in('manager', 'salesman') and e.ename like '%a%';

select e.ename, e.job, e.sal, s.grade from emp e join salgrade s
on e.sal between losal and hisal
and e.job in('manager', 'salesman') and e.ename like '%a%';


-- 사원명(emp), 급여(sal), 부서코드(emp, dept), 부서명(dept), 호봉(salgrade)을 선택하라.

select e.ename, e.sal, d.deptno, d.dname, s.grade
from emp e join dept d
on e.deptno = d.deptno
join salgrade s
on e.sal between s.losal and s.hisal;

-- 사원번호, 사원명, 입사일, 급여, 부서명, 호봉, 호봉의 초고급여를 선택하라.
-- 단, 급여가 2500불이상인 사원을 급여순으로 내림차순하여 선택하라.
select e.empno, e.ename, e.hiredate, e.sal, d.dname, s.grade, s.hisal
from emp e join dept d
on e.deptno=d.deptno
join salgrade s
on e.sal between losal and hisal
where e.sal>=2500
order by e.sal desc;

select * from emp;

-- self 조인 : 같은 테이블로 조인하기
-- 사원명, 담당업무, 급여, 매니저명, 매니저급여, 매니저업무 선택하라.
select e1.ename, e1.job, e1.sal, e2.ename, e2.sal, e2.job
from emp e1 join emp e2
on e1.mgr=e2.empno;

-- 사원명, 부서명, 급여, 매니저명, 매니저부서명, 매니저급여를 선택하라.
select * from emp;
select * from dept;

select
	e1.ename '사원명', d1.dname '부서명', e1.sal '급여', 
    e2.ename '매니저명', d2.dname '매니저부서명', e2.sal '매니저급여'
from emp e1 join dept d1 on e1.deptno = d1.deptno
join emp e2 on e1.mgr=e2.empno
join dept d2 on e2.deptno = d2.deptno;

select concat('a','b','c','d','e','f');
-- 문제 emp테이블에서 "누구의 관리자는 누구이다"는 내용을 출력하세요
select concat(e1.ename, '의 관리자는 ' , e2.ename, '이다.') '결과'
from emp e1 join emp e2
on e1.mgr = e2.empno;

-- outer join
-- null 데이터가 발생하는 테이블 오른쪽 -> left outer join
-- null 데이터가 발생하는 테이블 왼쪽 -> right outer join
select 
	ename, e.deptno, d.dname, d.deptno
from emp e right outer join dept d
on e. deptno = d.deptno;

select distinct e.deptno 'E', d.deptno 'D'
from dept d left outer join emp e
on d.deptno=e.deptno;
    
select * from emp;
select * from dept;

-- 1. emp테이블에서 모든 사원에 대한 이름, 부서번호, 부서명을 출력하는 문장을 작성하세요. (부서번호순으로 오름차순 정렬하라.)
select e.ename, e.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno order by e.deptno asc; -- order by e.deptno asc 부서번호로 정렬

-- 2. emp테이블에서 NEW YORK에서 근무하고 있는 사원에 대하여 이름, 업무, 급여, 부서명을 출력하는 SELECT문을 작성하세요.
select e.ename, e.job, e.sal, d.dname, d.loc
from emp e join dept d
on e.deptno=d.deptno and d.loc='new york';

-- 3. EMP테이블에서 보너스를 받는 사원에 대하여 이름, 부서명, 위치를 출력하는 SELECT문을 작성하세요.
select e.ename, d.dname, d.loc
from emp e join dept d
on emp.deptno=deptno
and ifnull(emp.comm,0)>0;



-- 4. EMP테이블에서 이름 중 L자가 있는 사원에 대해 이름, 업무, 부서명, 위치를 출력하는 문장을 작성하세요.
select a.ename, a.job, d.dname, d.loc
from (select ename, job, deptno from emp where ename like '%L%') a join dept d
on a.deptno=d.deptno;


-- 5. 아래의 결과를 출력하는 문장을 작성하세요(관리자가 없는 King을 포함하여 모든 사원을 출력)
-- -------------------------------------------------------------------------
-- Emplyee 	Emp# 	Manager 	Mgr#
-- KING 	7839
-- BLAKE 	7698 	KING 	7839
-- CKARK 	7782 	KING 	7839

select e.ename 'Emplyee', e.empno 'Emp#', e2.ename 'manager', e2.empno 'mgr#'
from emp e right outer join emp e2
on e.mgr = e2.empno;

-- natural join : 같은 필드명의 데이터를 알아서 조인 해준다.
select ename, sal, e.deptno, dname from emp e natural join dept d;

select ename, sal, dept.deptno, dname from emp join dept using(deptno);

show databases;
use mydb;
show tables;
desc member;
insert into member(username, tel, email, birth, gender)
values ('hong','010-1234-5678','hong@naver.com','2000-10-10', 'M');
select * from member;


