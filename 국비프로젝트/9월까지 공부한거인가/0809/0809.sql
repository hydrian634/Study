--CRUD
--C CREATE INSERT
--R READ/RETRIVE(�ҷ�����) SELECT
--U UPDATE UPDATE
--D DELETE DELETE

select * from member;

update member
set ADDRESS = 'YEOUNGDEUNGPO-GU, SEOUL, REPUBLIC OF'
where name = 'KANGHANEOL';

commit;

SELECT NAME, AGE+'100' AGE FROM MEMBER;
--���ڿ� ���ڿ��� �����ص� ���������� �̻� ������ ������ �ȴ�.
--���� SQL������ ||�� �̿��� ���ڿ��� ������ �õ��Ѵ�.
SELECT AGE || '��' AS AGE FROM MEMBER;

SELECT NAME || '(' || ID || ')' AS "NAME(ID)" FROM MEMBER;

-- != == ^= , <>

SELECT NAME, AGE FROM MEMBER WHERE AGE IS NULL;
--�ڸ�ǰ���� IS NOT NULL�� �ִ�.

SELECT NAME, AGE FROM MEMBER WHERE AGE IS NOT NULL;



