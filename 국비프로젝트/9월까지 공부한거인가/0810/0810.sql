SELECT * FROM MEMBER;

UPDATE MEMBER 
SET ADDRESS = 'YEOUNGDEUNGPO-GU, SEOUL, KOREA, REPUBLIC OF'
WHERE NAME = 'KANGHANEOL';
COMMIT;

SELECT * FROM MEMBER WHERE AGE BETWEEN 25 AND 30;
--MEMBER TABLE의 AGE COLUMN에서 25~30의 값을 가진 개체의 모든 것을 검색하라
SELECT * FROM MEMBER WHERE AGE IN (25, 27, 34);
--MEMBER TABLE의 AGE COLUMN에서 25, 27, 34의 값을 가진 개체의 모든 것을 검색하라
SELECT * FROM MEMBER WHERE AGE NOT IN (25, 27, 34, 32);
--MEMBER TABLE의 AGE COLUMN에서 25, 27, 34의 값을 가지지 않은 개체의 모든 것을 검색하라

SELECT * FROM MEMBER WHERE NAME LIKE 'K%';
-- 첫번째 글자로 K가 들어가는 이름을 가진 사람의 모든 것을 검색하라

SELECT * FROM MEMBER WHERE NAME LIKE '%H%';
-- 중간에 H가 들어가는 이름을 가진 사람의 모든 것을 검색하라.

SELECT * FROM MEMBER WHERE NAME LIKE '_A%';
-- 두 번째 글자(=첫번째 글자 뒤)에 A가 오고 뒤에 무언가 오는 사람의 모든 것을 검색하라.
-- _ 두 개 이상 쓸 수 있음


ROLLBACK;

SELECT * FROM MEMBER WHERE PHONE LIKE '%-___-%';
-- 전화번호 가운데가 세 자리인 개체의 모든 것을 검색하라.

-- [0-9] = \d
-- \d\d\d\d\d = \d{4}
SELECT * FROM MEMBER;

SELECT * FROM MEMBER WHERE PHONE LIKE '^01[016789]-\d{3,4}-\d{4}$';
-- ^ = START OF STRING
-- $ = END OF STRING

-- ^\d*(?:,\d{3})*원 = 금액 select. 123,456,789
-- ?:는 검사를 하지 말라는 의미? 이거 없으면 뒤에 ,789 이런 식으로 한번 더 나옴
-- \w = 문자를 출력 = 문자열을 하나하나 끊어서 출력 -> R/E/G/U/L/A/R/E/X/P/R/E/S/S/I/O/N/M/D/N
-- \w+ = 문자를 단어 단위로 출력. REGULAR EXPESSION MDN 을 \w+ 하면 REGULAR / EXPRESSION / MDN 순으로 출력
-- ^\w+ 가장 처음의 단어를 출력 / \w+$ = 가장 마지막의 단어를 출력.
-- \w+(?= MDN) ' MDN' 앞의 단어를 출력.
-- \w+@(?:\w+)(?:\.\w+)*

--SELECT * FROM NOTICE WHERE PHONE('^01[01679]-\d{3,4}-\d{4}$');


SELECT  * FROM MEMBER;


select * from member where name like '%KANG%';