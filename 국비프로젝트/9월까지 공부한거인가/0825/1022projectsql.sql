show schemas;

show tables;

select * from store;
select * from review;
select * from restaurant;
select * from `admin`;

select rv.review_id, rv.user_id, rv.rest_id, rv.rating, rv.content, rv.img, rv.created_date, r.rest_name, r.banner_img, user.user_id
from review rv
left join restaurant as r on (rv.rest_id = r.rest_id);

create view review_view as
(
select rv.review_id, rv.user_id, rv.rest_id, rv.rating, rv.content, rv.img, rv.created_date, r.rest_name, r.banner_img
from review rv
left join restaurant as r on (rv.rest_id = r.rest_id));

select rvv.*, user.alias from review_view rvv
left join user on (rvv.user_id = user.user_id);

select * from user;

select * from review_view;