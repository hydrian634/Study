--DECLARE
--x NUMBER := 2;
--BEGIN
--x:= x+30;
--DBMS_OUTPUT.PUT_LINE(x);
--DBMS_OUTPUT.PUT_LINE('HELLO');
--END;

--------------------------------------------------

--CREATE OR REPLACE PROCEDURE IF_PROCE
--IS
--DECLARE
--X NUMBER := 2;
--COUNT NUMBER;
--BEGIN
--X := &NUMBER;
--IF X > 5 THEN
--DBMS_OUTPUT.PUT_LINE('BIG VALUE');
--ELSE
--DBMS_OUTPUT.PUT_LINE('SMALL VALUE');
--END IF;
--END;

--------------------------------------------------

--DECLARE
--I NUMBER := 0;
--N NUMBER := 0;
--CNT NUMBER := 0;
--BEGIN
--CNT := 10;
----&변수명을 통해 입력도 받을 수 있다.
--WHILE I < CNT LOOP
--DBMS_OUTPUT.PUT_LINE(I);
--N := N +(I+1);
--I := I+1;
--END LOOP;
--DBMS_OUTPUT.PUT_LINE(N);
--END;

----------------------------------------------------

--CREATE OR REPLACE FUNCTION HAN_AGE(
--V_BIRTH_DATE IN VARCHAR2
--)
--RETURN NUMBER
--IS
--V_AGE NUMBER := 0;
--V_YEAR VARCHAR2(100);
--BEGIN
--SELECT TO_CHAR(SYSDATE, 'YYYY')
--INTO V_YEAR
--FROM DUAL;
--
--DBMS_OUTPUT.PUT_LINE(V_YEAR);
--
--END;

--DROP FUNCTION HAN_AGE;
