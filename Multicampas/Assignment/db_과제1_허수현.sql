use mydb;
show tables;

CREATE TABLE book
       (bookNo CHAR(10) NOT NULL primary key,
        bookTitle VARCHAR(30),
        bookAuthor VARCHAR(20),
        bookYear INT,
        bookPrice INT,
        bookPublisher CHAR(10));
        
INSERT INTO book VALUES('B001', '자바프로그래밍',  '홍길동', 2021, 30000, '서울출판사');
INSERT INTO book VALUES('B002', '데이터베이스',  '이몽룡', 2020, 25000, '멀티출판사');
INSERT INTO book VALUES('B003', 'HTML/CSS',  '성춘향', 2021, 18000, '강남출판사');
        