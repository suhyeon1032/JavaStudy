use demo;
select * from emp;
show databases;
create database mydb;
use mydb;
-- 테이블 생성하기
create table member(
-- 필드명   데이터타입   제약조건   기본값
	num int auto_increment primary key,
    username varchar(30) not null, 
    tel varchar(15) not null,
    email varchar(50), -- null 허용 생략가능
    birth date, -- null 허용 생략 가능
    gender char(1) default 'M', 
    writedate datetime default now()
);
show tables;
desc member;
drop table usertbl;

-- 회원등록
create table usertbl(
	userId varchar(30) primary key,
	userName varchar(30) not null,
    brith year not null,
    local varchar(50) not null,
    hireDate date,
    mobile varchar(4),
    mobile2 varchar(10), -- 010-1234-5678 중에 1234-5678
    height int(3),
    writeDate datetime
);
show tables;
desc usertbl;

-- 상품테이블
create table prodtbl(
	productname varchar(100) primary key,
    price int default 0,
    opendate datetime,
    company varchar(50),
    stock int
);

-- 구매테이블
create table buytbl(
	buyno integer auto_increment, 
    userid varchar(30) not null,
    productname varchar(50) not null,
    groupname varchar(40) not null,
    price int default 0,
    amount int default 0,
    buydate datetime default now(),
    primary key (buyno)
);

-- 테이블지우기
-- drop table member;

show tables;
desc booktbl;