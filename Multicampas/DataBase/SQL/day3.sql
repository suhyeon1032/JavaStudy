use demo;
select * from emp;
SELECT empno, ename, hiredate, sal FROM emp ORDER BY ename asc;

desc emp;
-- insert문 레코드 추가
-- 모든 필드의 정보가 있을 때 
insert into emp values(7777, 'hong', '총무부', 7369, now(), 3000, 100, 40);
-- 사원번호, 이름만 있을 때
insert into emp(empno, ename) values(8888, 'park');
-- insert into emp(ename, sal) values('choi', 5000); -- EMPNO가 desc emp; 로 확인 헸을때 no NUll 이기 때문에 작성해야 한다.
insert into emp(empno, ename, sal) values(9999, 'choi', 5000);

-- 테이블 복사
-- select 시킨 내용을 emp2에 만든다.
create table emp2
as
select empno, ename, job, sal from emp where job='MANAGER';

-- table 만들어졌는지 확인
show tables;

-- 테이블 만들어지면서 내용 복사 된 것 확인
select * from emp2;

-- emp의 테이블에 있는 레코드 중 급여가 3000이상인 사원을 emp2에 추가하여라. 
-- 사원번호, 이름, 담당업무, 급여
insert into emp2(empno, ename, job, sal)
select empno, ename, job, sal from emp where sal>=3000;

-- 현재 테이블 정보 확인
select * from emp2; -- choi의 job이 없음
-- update문 : 레코드 수정
update emp2 set job='인사부' where empno=9999;
-- update 오류 해결
-- https://cafe.naver.com/goguma777?iframe_url_utf8=%2FArticleRead.nhn%253Fclubid%3D15731328%2526page%3D1%2526menuid%3D81%2526boardtype%3DL%2526articleid%3D2493%2526referrerAllArticles%3Dfalse
-- 설정하고 workbench 껐다 켜야함
select * from emp2;

-- ford 사원이 job을 기획부, 급여를 1000불 인상하여라.
update emp2 set job='기획부', sal= sal+1000 where ename='ford';
select * from emp2;
-- emp2의 모든 사원의 급여 10%인상한 급여로 수정하라
update emp2 set sal = sal*1.1;
select * from emp2;

-- delete문 : 레코드 삭제
-- 7777번 사원을 삭제하라
delete from emp2 where empno=7777;
select * from emp2;

delete from emp2 where job='인사부';

-- 오토커밋 autocommit
-- https://cafe.naver.com/goguma777?iframe_url_utf8=%2FArticleRead.nhn%253Fclubid%3D15731328%2526page%3D1%2526menuid%3D81%2526boardtype%3DL%2526articleid%3D2494%2526referrerAllArticles%3Dfalse
-- 현재 autocommit 상태 확인 (1 이었음)
select @@autocommit;
-- 1 : 자동커밋, 0 : 자동커밋안됨
set autocommit = 1; -- (0으로 바뀜)
-- ename으로 오름차순
select * from emp order by ename asc;


-- 사원등록
insert into emp(empno, ename) values(1111, 'lee');
-- set autocommit = 0; 을 해놨기 때문에 오토 커밋이 해제 되어 완료된 정보가 아니어서 이클립스에서 접속하면 lee라는 데이터를 볼 수 없음
delete from emp where empno=7777;
delete from emp where ename='choi';
-- update, insert, delete의 레코드 변경된 경우 작업을 완료하는 기능이다.


commit; -- 앞에 작업 한 내용을 완전히 기록해 저장한다. 하면 외부 이클립스에도 적용된다.

delete from emp where ename='lee';
select * from emp order by ename asc;
rollback; -- 방금 했던 작업 취소

-- savepoint
select * from emp order by ename asc;
savepoint a;
insert into emp(empno, ename) values(2222, 'aaaaa');
insert into emp(empno, ename) values(3333, 'bbbbb');

savepoint b;
delete from emp where empno=1111;
delete from emp where job='salesman';

savepoint c;
update emp set comm=5000;

rollback to savepoint b;

select * from emp;




