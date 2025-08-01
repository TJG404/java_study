use hrdb2019;
select database();
show tables;
desc member;

select * from score_member;
select count(*) from score_member;
select mid, name, department, kor, eng, math, mdate
from score_member;
select row_number() over() as rno, 
					mid, name, department, kor, eng, math, mdate
					from score_member;

-- score_member 테이블 생성
create table score_member(
	mid		char(5)		primary key,  -- 'M0001' 형식의 트리거 적용
    name	varchar(10)	not null,
    department varchar(20),
    kor		decimal(6,2) default 0.0,
    eng		decimal(6,2) default 0.0,
    math    decimal(6,2) default 0.0,
    mdate	datetime
);
desc score_member;
select * from information_schema.triggers;

-- 트리거 생성
/************************************************/
delimiter $$
create trigger trg_score_member_mid
before insert on score_member -- 테이블명
for each row
begin
declare max_code int;  --  'M0001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
SELECT IFNULL(MAX(CAST(right(mid, 4) AS UNSIGNED)), 0)
INTO max_code
FROM score_member; 

-- 'M0001' 형식으로 아이디 생성, LPAD(값, 크기, 채워지는 문자형식) : M0001
SET NEW.mid = concat('M', LPAD((max_code+1), 4, '0'));

end $$
delimiter ;
/************************************************/

select * from score_member;












