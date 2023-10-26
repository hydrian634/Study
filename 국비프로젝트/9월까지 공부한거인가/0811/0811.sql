SELECT * FROM MEMBER;

SELECT * FROM MEMBER WHERE REGEXP_LIKE(PHONE, '^01[01679]-\d{3,4}-\d{4}$');

SELECT * FROM MEMBER WHERE NOT REGEXP_LIKE(PHONE, '^01[01679]-\d{3,4}-\d{4}$');

SELECT ROWNUM, MEMBER.* FROM MEMBER;

SELECT ROWNUM, MEMBER.* FROM MEMBER WHERE ROWNUM BETWEEN 1 AND 5;
SELECT ROWNUM, MEMBER.* FROM MEMBER WHERE ID BETWEEN 1 AND 5 ORDER BY ID ASC;

SELECT ROWNUM, MEMBER.* FROM MEMBER WHERE ROWNUM BETWEEN 1 AND 5;

SELECT * FROM (SELECT ROWNUM NUM, MEMBER.* FROM MEMBER) WHERE NUM BETWEEN 6 AND 10;
--SUBQUARY

--DISTINCT 중복값 제거
SELECT DISTINCT AGE FROM MEMBER;
SELECT AGE FROM MEMBER;

SELECT NAME FROM MEMBER;
SELECT NAME, LENGTH(NAME) AS NAME_LENGTH FROM MEMBER;

SELECT NAME FROM MEMBER WHERE LENGTH(NAME) > 3;

SELECT COUNT(NAME) FROM MEMBER;

SELECT SUBSTR(NAME,1,3) FROM MEMBER;

SELECT MAX(AGE) FROM MEMBER;
SELECT MIN(AGE) FROM MEMBER;
SELECT AVG(AGE) FROM MEMBER;
SELECT SUM(AGE) FROM MEMBER;
--GROUP BY, HAVING, ORDER BY
SELECT NAME, AGE FROM MEMBER;

SELECT  AGE, COUNT(NAME) CNT_AGE
FROM MEMBER
--WHERE AGE IS NOT NULL
GROUP BY AGE;
--HAVING COUNT(NAME) > 3;

SELECT FLOOR(15/10)*10 FROM DUAL;

SELECT AGE FROM MEMBER WHERE AGE = 32;

SELECT AGE, COUNT(AGE), 
FROM MEMBER
GROUP BY AGE
ORDER BY AGE ASC;

SELECT FLOOR(AGE/10)*10 AS AGE_TH, COUNT(FLOOR(AGE/10)*10)
FROM MEMBER
GROUP BY FLOOR(AGE/10)*10
ORDER BY AGE_TH ASC;

SELECT AGE FROM MEMBER;

---------------------------------------------
SELECT * FROM MEMBER ORDER BY NAME DESC, ID ASC;
SELECT * FROM MEMBER ORDER BY NAME DESC;
---------------------------------------------
