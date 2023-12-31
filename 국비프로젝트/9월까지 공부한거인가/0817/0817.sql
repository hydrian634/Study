-- ANSI SQL
SELECT N.ID, N.TITLE, M.NAME
FROM MEMBER M
JOIN NOTICE N
ON M.ID = N.REG_MEMBER_ID;
--WHERE M.ID = 'NEWLEC';

--ORACLE SQL
SELECT N.ID, N.TITLE, M.NAME
FROM MEMBER M, NOTICE N
WHERE M.ID = N.REG_MEMBER_ID;

---------------------------------------------------------------
SELECT * FROM MEMBER;
SELECT * FROM NOTICE;
---------------------------------------------------------------
SELECT *
FROM MEMBER M, NOTICE N
WHERE M.ID(+) = N.REG_MEMBER_ID;

SELECT *
FROM MEMBER M LEFT OUTER JOIN NOTICE N
ON M.ID = N.REG_MEMBER_ID;
----------------------------------------------------------------
--UNION
--JOIN은 COLUMN을 합침(확장)
--UNION은 RECORD를 합침(확장)

SELECT * FROM NOTICE
WHERE LENGTH(TITLE)=5;
UNION
SELECT * FROM NOTICE
WHERE LENGTH(TITLE) = 4;

SELECT ID, TITLE, 'CATEGORY' FROM CATEGORY
WHERE LENGTH(NAME)=2;
UNION
SELECT ID, TITLE FROM NOTICE
WHERE LENGTH(TITLE) = 4;
--UNION : 중복을 허용하지 않고(=중복이 있으면 하나 지우고) 테이블을 합쳐줌.
SELECT ID, TITLE FROM NOTICE
WHERE LENGTH(TITLE) IN (4,5);
--IN은 ()안의 값 중 하나라도 일치하면 TRUE

SELECT ID, NAME FROM CATEGORY
WHERE LENGTH(NAME) =2
MINUS --UNION, UNION ALL, MINUS, INTERSECT
SELECT ID, TITLE FROM NOTICE
WHERE LENGTH(TITLE) = 2;
--MINUS : 차집합
--INTERSECT : 교집합
--UNION : 중복 불허 합집합
--UNION ALL : 중복 허가 합집합

SELECT * FROM CATEGORY;
SELECT * FROM NOTICE;

SELECT N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME
FROM NOTICE N 
RIGHT OUTER JOIN MEMBER M
ON N.REG_MEMBER_ID = M.ID
WHERE N.REG_MEMBER_ID IS NOT NULL
;

SELECT N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME
FROM NOTICE N 
LEFT OUTER JOIN MEMBER M
ON N.REG_MEMBER_ID = M.ID
;

SELECT N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME
FROM NOTICE N
JOIN MEMBER M
ON N.REG_MEMBER_ID = M.ID;



SELECT * FROM NOTICE;
SELECT * FROM MEMBER;

SELECT * FROM "COMMENT";

INSERT INTO "COMMENT" (REG_DATE) VALUES (SYSTIMESTAMP);

SELECT * FROM "COMMENT";

INSERT INTO "COMMENT" ("CONTENT", REG_DATE) VALUES ('ADSF',SYSTIMESTAMP);

COMMIT;
ROLLBACK;

SELECT N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME REG_MEMBER_NAME , COUNT(C.ID) CNT_CONTENT
FROM NOTICE N 
LEFT OUTER JOIN MEMBER M
ON N.REG_MEMBER_ID = M.ID
LEFT OUTER JOIN "COMMENT" C
ON C.NOTICE_ID = N.ID
GROUP BY  N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME
;
--댓글 개수
SELECT * FROM
(
SELECT N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME REG_MEMBER_NAME , COUNT(C.ID) CNT_CONTENT
FROM NOTICE N 
LEFT OUTER JOIN MEMBER M
ON N.REG_MEMBER_ID = M.ID
LEFT OUTER JOIN "COMMENT" C
ON C.NOTICE_ID = N.ID
GROUP BY  N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME
)
WHERE ROWNUM BETWEEN 1 AND 10
;
--내부로 파고드는 생각도 좋지만 가끔은 바깥으로 빠져나올줄 알아야한다.
SELECT N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME REG_MEMBER_NAME , COUNT(C.ID) CNT_CONTENT
FROM NOTICE N 
LEFT OUTER JOIN MEMBER M
ON N.REG_MEMBER_ID = M.ID
LEFT OUTER JOIN "COMMENT" C
ON C.NOTICE_ID = N.ID
GROUP BY N.ID, N.TITLE, N.REG_MEMBER_ID, M.NAME
;