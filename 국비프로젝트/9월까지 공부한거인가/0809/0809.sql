--CRUD
--C CREATE INSERT
--R READ/RETRIVE(불러오다) SELECT
--U UPDATE UPDATE
--D DELETE DELETE

select * from member;

update member
set ADDRESS = 'YEOUNGDEUNGPO-GU, SEOUL, REPUBLIC OF'
where name = 'KANGHANEOL';

commit;

SELECT NAME, AGE+'100' AGE FROM MEMBER;
--숫자와 문자열을 결합해도 숫자형태인 이상 수학적 덧셈이 된다.
--따라서 SQL에서는 ||를 이용해 문자열의 결합을 시도한다.
SELECT AGE || '살' AS AGE FROM MEMBER;

SELECT NAME || '(' || ID || ')' AS "NAME(ID)" FROM MEMBER;

-- != == ^= , <>

SELECT NAME, AGE FROM MEMBER WHERE AGE IS NULL;
--자매품으로 IS NOT NULL이 있다.

SELECT NAME, AGE FROM MEMBER WHERE AGE IS NOT NULL;



