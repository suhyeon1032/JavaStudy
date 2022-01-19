-- 테이블 관리
use demo;
show tables;
desc emp2;
select * from emp2;

-- 테이블에 필드를 추가한다.
-- emp2테이블에 연락처를 저장 할 필드 추가
alter table emp2 add tel varchar(15);

-- 필드의 크기를 수정하기
-- job을 varchar(20)자리로 바꾸기
alter table emp2 modify job varchar(20);

-- 컬럼명 변경하기
-- tel -> mobile로 컬럼명 변경하기
alter table emp2 change tel mobile varchar(20);

desc emp2;
desc emp;

-- 필드 삭제하기
-- job을 삭제하기
alter table emp2 drop column job;

-- emp2테이블 지우기
drop table emp2;
show tables;

select * from emp;
alter table emp add job varchar(50);

delete from emp where empno in(1111,2222,3333);
commit;

select @@autocommit;

-- 제약조건 확인하기
select * from information_schema.table_constraints
where table_name in ('emp', 'dept', 'salgrade');

select * from emp;
-- unique : 유일한 값일때
-- ename을 unique 제약조건 설정
alter table emp add constraint emp_uq_ename unique(ename);
insert into emp(empno, ename) values(8888, 'smith');

-- 제약조건 삭제
alter table emp drop constraint emp_uq_ename;
-- check : 특정 데이터만 등록 되도록 제약 조건을 설정한다.
alter table emp add constraint emp_ck_sal check(sal > 500 and sal < 8000);
update emp set sal=7900 where ename='smith';

alter table emp add constraint emp_ck_comm check(comm in(100,200,300,400));
update emp set comm=100;
select * from emp;

update emp set comm=200 where sal>3000;
update emp set comm=300 where sal<2000;

select * from emp;
select * from dept;

-- primary key 설정
-- dept테이블 deptno필드를
alter table dept add constraint dept_pk_deptno primary key (deptno);

-- 제약조건 확인하기
select * from information_schema.table_constraints
where table_name in ('emp', 'dept', 'salgrade');

insert into dept values(50, '총무부', '서울');

-- 외래키 설정
-- emp테이블의 deptno는 detp테이블의 deptno를 참조한다.
alter table emp add constraint emp_fk_deptno foreign key (deptno)
references dept(deptno);

select * from dept;
select * from emp;
-- emp에서 martin 50번 부서로 이동
update emp set deptno=50 where ename='martin';
update emp set deptno=35 where ename='jones';

delete from dept where deptno=20;

alter table emp drop constraint emp_fk_deptno;
-- 안됨,,,,
alter table emp add constraint emp_fk_deptno foreign key(deptno)
references dept(deptno) on delete cascade;

delete from dept where deptno=20; -- 실행하면 dept와 emp에서 deptno에 20인 사원이 다 사라져야함
select * from dept;
select * from emp;
select avg(sal) from emp;
select * from emp where sal>2016.66667;

select * from emp where sal>(select avg(sal) from emp);


