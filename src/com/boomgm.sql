use hrdb2019;
select database();

-- 테이블 3개 생성, book_tj, book_yes24, book_aladin
-- bid:pk('B001',트리거생성), title, author, price, isbn(랜덤 정수4자리생성), bdate
show tables;
create table book_tj(
	bid		char(4)		primary key,
    title	varchar(50)	not null,
    author	varchar(10),
    price 	int,
    isbn	int,
    bdate 	datetime
);
create table book_yes24(
	bid		char(4)		primary key,
    title	varchar(50)	not null,
    author	varchar(10),
    price 	int,
    isbn	int,
    bdate 	datetime
);
create table book_aladin(
	bid		char(4)		primary key,
    title	varchar(50)	not null,
    author	varchar(10),
    price 	int,
    isbn	int,
    bdate 	datetime
);
select * from information_schema.triggers;
/************************************************/
delimiter $$
create trigger trg_book_aladin_bid
before insert on book_aladin -- 테이블명
for each row
begin
declare max_code int;  --  'M0001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
SELECT IFNULL(MAX(CAST(right(bid, 3) AS UNSIGNED)), 0)
INTO max_code
FROM book_aladin; 

-- 'M0001' 형식으로 아이디 생성, LPAD(값, 크기, 채워지는 문자형식) 
SET NEW.bid = concat('B', LPAD((max_code+1), 3, '0'));

end $$
delimiter ;
/************************************************/

-- Connection 확인 
SHOW STATUS LIKE 'Threads_connected'; 	-- 접속 커넥션 수
SHOW PROCESSLIST;  						-- 활성중인 커넥션
SHOW VARIABLES LIKE 'max_connections';  -- 최대 접속 가능 커넥션 수

select * from book_aladin;
select * from book_tj;
















 