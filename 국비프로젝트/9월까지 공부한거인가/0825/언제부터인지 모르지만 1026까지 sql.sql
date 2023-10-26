show tables;

select @@version;

select * from menu;

select count(id)
from menu
group by id;

select * from menu
where id = 1;

select * from menu;
select * from rlanddb.like;

create view menu_view_haneol
as
select m.id, m.kor_name, m.eng_name, m.price, m.img, m.reg_date, m.hit, m.member_id, count(l.menu_id) as like_count from menu as m
left join rlanddb.like as l on m.id=l.menu_id
group by m.id;
;

drop view menu_view_haneol;



select m.id, m.kor_name, m.eng_name, m.price, m.img, m.reg_date, m.hit, m.member_id, count(l.menu_id) as like_count from menu as m
left join rlanddb.like as l on m.id=l.menu_id
group by m.id, m.kor_name, m.eng_name, m.price, m.img, m.reg_date, m.hit, m.member_id;

select * from `like`;
select count(*) from `like`
group by menu_id;


select * from menu_view;

select * from menu_view;

select * from menu_view
where category_id = 1
and kor_name like "%커피%"
order by reg_date desc
limit 0,8;

insert into  receive (id, menu_id, amount)
values (9, 270, 3);

select * from receive;

SELECT 
        `m`.`id` AS `id`,
        `m`.`kor_name` AS `kor_name`,
        `m`.`eng_name` AS `eng_name`,
        `m`.`price` AS `price`,
        `m`.`img` AS `img`,
        `m`.`reg_date` AS `reg_date`,
        `m`.`hit` AS `hit`,
        `m`.`member_id` AS `member_id`,
        `m`.`category_id` AS `category_id`,
        `m`.`amout` as `amout`,
        COUNT(`l`.`menu_id`) AS `like_count`,
		? as receive_count
    FROM
        (`menu` `m`
        LEFT JOIN `like` `l` ON (`m`.`id` = `l`.`menu_id`))
    GROUP BY `m`.`id` , `m`.`kor_name` , `m`.`eng_name` , `m`.`price` , `m`.`img` , `m`.`reg_date` , `m`.`hit` , `m`.`member_id` , `m`.`category_id`;
    
select *, sum(amount) as receive_amount
from receive
group by id, menu_id, amount, reg_date;

select * from category;
select * from `like`;
select * from member;
select * from menu_view;
select * from menu_view where category_id = 4;
select * from member;

select user_name, password, 1enabled from member
where user_name = 'newlec';
select * from menu;

select * from member;
select * from member_role;
select * from role;

select m.user_name as username, r.name as Auth 
from member_role mr 
left join member m on mr.member_id = m.id 
left join role r on mr.role_id = r.id 
where m.user_name = "newlec";

select r.name as Auth from member_role mr
left join role r on mr.role_id = r.id;

select * from `like`;
select * from member;

select * from member
order by reg_date desc;

select * from member
order by id desc limit 1;

