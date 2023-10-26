SELECT * FROM MEMBER;

UPDATE MEMBER 
SET ADDRESS = 'YEOUNGDEUNGPO-GU, SEOUL, KOREA, REPUBLIC OF'
WHERE NAME = 'KANGHANEOL';
COMMIT;

SELECT * FROM MEMBER WHERE AGE BETWEEN 25 AND 30;
--MEMBER TABLE�� AGE COLUMN���� 25~30�� ���� ���� ��ü�� ��� ���� �˻��϶�
SELECT * FROM MEMBER WHERE AGE IN (25, 27, 34);
--MEMBER TABLE�� AGE COLUMN���� 25, 27, 34�� ���� ���� ��ü�� ��� ���� �˻��϶�
SELECT * FROM MEMBER WHERE AGE NOT IN (25, 27, 34, 32);
--MEMBER TABLE�� AGE COLUMN���� 25, 27, 34�� ���� ������ ���� ��ü�� ��� ���� �˻��϶�

SELECT * FROM MEMBER WHERE NAME LIKE 'K%';
-- ù��° ���ڷ� K�� ���� �̸��� ���� ����� ��� ���� �˻��϶�

SELECT * FROM MEMBER WHERE NAME LIKE '%H%';
-- �߰��� H�� ���� �̸��� ���� ����� ��� ���� �˻��϶�.

SELECT * FROM MEMBER WHERE NAME LIKE '_A%';
-- �� ��° ����(=ù��° ���� ��)�� A�� ���� �ڿ� ���� ���� ����� ��� ���� �˻��϶�.
-- _ �� �� �̻� �� �� ����


ROLLBACK;

SELECT * FROM MEMBER WHERE PHONE LIKE '%-___-%';
-- ��ȭ��ȣ ����� �� �ڸ��� ��ü�� ��� ���� �˻��϶�.

-- [0-9] = \d
-- \d\d\d\d\d = \d{4}
SELECT * FROM MEMBER;

SELECT * FROM MEMBER WHERE PHONE LIKE '^01[016789]-\d{3,4}-\d{4}$';
-- ^ = START OF STRING
-- $ = END OF STRING

-- ^\d*(?:,\d{3})*�� = �ݾ� select. 123,456,789
-- ?:�� �˻縦 ���� ����� �ǹ�? �̰� ������ �ڿ� ,789 �̷� ������ �ѹ� �� ����
-- \w = ���ڸ� ��� = ���ڿ��� �ϳ��ϳ� ��� ��� -> R/E/G/U/L/A/R/E/X/P/R/E/S/S/I/O/N/M/D/N
-- \w+ = ���ڸ� �ܾ� ������ ���. REGULAR EXPESSION MDN �� \w+ �ϸ� REGULAR / EXPRESSION / MDN ������ ���
-- ^\w+ ���� ó���� �ܾ ��� / \w+$ = ���� �������� �ܾ ���.
-- \w+(?= MDN) ' MDN' ���� �ܾ ���.
-- \w+@(?:\w+)(?:\.\w+)*

--SELECT * FROM NOTICE WHERE PHONE('^01[01679]-\d{3,4}-\d{4}$');


SELECT  * FROM MEMBER;


select * from member where name like '%KANG%';