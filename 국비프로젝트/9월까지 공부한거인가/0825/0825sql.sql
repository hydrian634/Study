show tables;
show schemas;
select now();

alter table store add constraint chk_rating check (rating>0 and rating <= 5);
alter table store drop constraint chk_rating;
insert into store (rating) values (6);

select * from user;

insert into user (pwd, nickname, email, phone, user_name, profile_url) values ('1234', 'hek', 'skyaliqo0206@gmail.com', '01090943145', 'haneol kang', '');
delete from user where nickname = 'hek';
alter table menu add constraint chk_price check (price > 0);
/*이거 아직 없는 테이블이라 써야됨.*/
insert into admin (password,nickname,email,phone_number) values ('1234','hek','skyaliqo0206@gmail.com','010-9094-3145');
select * from admin;
select * from information_schema.table_constraints;

/*alter table 'member' add constraint chk_member check (phone rlike '^01[016]-\\d{3,4}-\\d{4}$');*/

/*
도메인 제약조건 : 도메인 단위의 제약조건
-domain : 어떤 변수(변량?, 필드, 속성, 칼럼,...)에 들어가는 올바른 값의 범위
	1. 컬럼 중에는 필수/옵션 칼럼이 있다.
    -필수 칼럼은 데이터를 필수로 필요로 한다.
     = not null 제약조건
     2. 모든 칼럼이 다 NN이다... 다 넣어야 하나...
     -사용자가 입력할 필요가 없는 것은 default/expression에 넣으면 됨.
     -
     3.전화번호, 이메일 과 같은 칼럼에 어떠한 값이 들어왔을 때
     그 것이 해당 칼럼과 어울리는? 맞는? 값인가 확인하는 제약조건.
     check 제약 조건
     workbench에 check제약조건 거는 방법을 안만들어둠 -> quary로 작성해야함.
     alter table 'member' add constraint chk_member check (phone rlike '^01[016]-\\d{3,4}-\\d{4}$');

엔티티 제약조건 : 
	1. primary key
		
    2. unique
		고유값을 가지게 함.

관계 제약 조건 : 
	1. commentcomment

*/
select * from community_report;

alter table review add constraint fk_storetoreview_storeid foreign key (store_id) references store(store_id) on update cascade;
alter table review drop constraint fk_storetoreview_storeid;
alter table community_report add constraint user_id foreign key (user_id) references user(user_id) on update cascade;
alter table community_report drop constraint user_id;


select * from community_report;
alter table admin rename column phone_number to phone;
alter table admin drop column phone;

select * from user;

create table menu(
menu_id bigint(5) not null,
rest_id bigint(5) not null,
name varchar(10) not null,
price bigint(6) not null,
primary key(menu_id, rest_id),
constraint fk_resttomenu_restid foreign key (rest_id) references restaurant(rest_id)
);

create table celeb_restaurant(
celeb_rest_id bigint(5) primary key,
celeb_id bigint(5),
constraint fk_celebtocelebrest_celebid foreign key (celeb_id) references celeb(celeb_id)
);

create table celeb(
celeb_id bigint(5) primary key,
name varchar(5)
);
