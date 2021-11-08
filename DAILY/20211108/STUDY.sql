-- 1�� ����
--�μ����� �׷��Ͽ� �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ��ȸ�ϼ���.
    SELECT NVL(DEPT_CODE, '���Ҽ�') �μ���ȣ, COUNT(*) �ο���, ROUND(AVG(SALARY)) �޿����, SUM(SALARY) �޿��u
    FROM EMPLOYEE
    GROUP BY DEPT_CODE;
    
    
    
    
    
-- 2�� ����
-- �ڽ��� ���� ������ ��� �޿����� ���� �޴� ����� �̸�, ���޸�, �޿� ���� ��ȸ�ϼ���.
SELECT EMP_NAME �̸�, JOB_NAME ���޸�, SALARY �޿�
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE SALARY > (SELECT ROUND(AVG(SALARY))
                FROM EMPLOYEE EMP
                WHERE E.JOB_CODE = EMP.JOB_CODE
                GROUP BY JOB_CODE);
                
                
                
                
                
-- 3�� ����
-- ȸ�翡�� �ް�ö�� �¾� �� ������� �ؿܿ����� �����ַ��� �մϴ�.
-- ������� �޿��� ���� �����ַ��� �Ͽ�
-- S1,S2 �� ������� �̱�, S3, S4�� ������� �߱�, S5, S6�� ������� �Ϻ��� ���������ؿ�.
-- ��, ���� �ٹ��ϰ� �ִ� ������ ������ �ؿܿ����� �����ַ��� ������ ���� ���, ���������� �����ָ�
-- ��ǥ�� �ް����� ����ؼ� �ٹ��� �ϱ�� �մϴ�.
-- EMPLOYEE ���̺��� �̿� ���� ���ǿ� �´�
-- ���, �����, �μ���, ���α�����(NATIONAL_NAME), �޿����, �ް������� �� ��� ������������ ��ȸ�ϼ���.
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME ���α�����, SAL_LEVEL �޿����, 
    CASE
        WHEN JOB_CODE = 'J1' THEN '�ٹ�'
        WHEN SAL_LEVEL IN ('S1', 'S2') AND NATIONAL_NAME = '�̱�' THEN '��������'  --> �̰� ������ �;��� WHY ? �ȱ׷��� S1S2���� �� �ɷ�������
        WHEN SAL_LEVEL IN ('S1', 'S2') THEN '�̱�'
        WHEN SAL_LEVEL IN ('S3', 'S4') AND NATIONAL_NAME = '�߱�' THEN '��������'
        WHEN SAL_LEVEL IN('S3', 'S4') THEN '�߱�'
        WHEN SAL_LEVEL IN ('S5', 'S6') AND NATIONAL_NAME = '�Ϻ�' THEN '��������'
        WHEN SAL_LEVEL IN ('S5', 'S6') THEN '�Ϻ�'
    END �ް�������
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
LEFT JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
ORDER BY EMP_ID;





-- 4�� ����
--��� ����� �޿��� ������ '��00,000,000'�������� ���ϼ���
SELECT TO_CHAR(SUM(SALARY),'L999,999,999')�޿�����
FROM EMPLOYEE;





-- 5�� ����
--�μ� �ڵ尡 D9�� ������� �޿� �� ���� �޿����� ���� �޿��� �޴� ����� �̸��� �޿��� ����ϼ���
SELECT EMP_NAME �̸�, SALARY �޿�
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' AND SALARY > (SELECT MIN(SALARY)
                                        FROM EMPLOYEE);
                                        
                                        
                                        
                                  
-- 6�� ����
--'D6'�� �μ��� ��� �߿��� �޿��� ���� ���� �޴� ������� �� ���� �޿��� �޴� ����� �̸��� �޿��� ����غ�����.
SELECT EMP_NAME �̸�, SALARY �޿�
FROM EMPLOYEE
WHERE SALARY > (SELECT MAX(SALARY)
                FROM EMPLOYEE
                WHERE DEPT_CODE = 'D6');                                        
                
                
                
                
                
-- 7�� ����
-- ȸ���� ���������� ���Ͽ� ���������� �Ұ����������ϴ�.
-- �켱 ���� ����� �ľ��ϱ� ���� (EMPLOYEE ���̺���) ��� ������ ���, �����, ����, �μ���, �ٹ�������
-- �����ڵ�� ����� ������������ ��ȸ�ϼ���.
SELECT EMP_ID ���, EMP_NAME �����, J.JOB_NAME ���޸�, D.DEPT_TITLE �μ���, L.LOCAL_NAME ������
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
ORDER BY E.JOB_CODE, EMP_ID DESC;






-- 8�� ����
-- ��� ������ �ǹ̷� �Ѵ޿� �ѹ� �系 �̺�Ʈ�� ����˴ϴ�.
-- ���� ��÷�� ���� �̺�Ʈ ��÷�� ��ǥ�� ���� ������ ��ȸ�ϼ���. (��� ������ �ּ��Ѹ� ����ǰ� �ϱ� ���� ���� ������ �����ؾ� �մϴ�)
-- ��÷���� ���, �����(��� ���ڴ� '*'���� ǥ��), ���̵�(�̸��Ͽ��� ���̵� ����), ����ó(��� 4�ڸ��� '****'���� ǥ��)
-- �̹� �� ��÷�ڴ� �ֹι�ȣ ������ �ڸ��� '1'�� ������Դϴ�.
SELECT EMP_ID ���,
    SUBSTR(EMP_NAME, 1, 1)||LPAD('*', LENGTH(EMP_NAME) -2)||SUBSTR(EMP_NAME, 3) �����,
       SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) ���̵�,
       NVL(SUBSTR(PHONE, 1, 3)||LPAD('*', LENGTH(PHONE) -7, '*')||SUBSTR(PHONE, 8, 5), '����') ����ó
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 14, 1) = 1;




-- 9�� ����
-- ������, �μ���, �ο���, �޿��հ�, �޿������ ��ȸ�ϵ�,
-- ������� �μ��� ���� ��� ��ȸ�ϰ�,
-- ������ ������ ��������, �μ��� �������� ������ �����ϼ���.
--, DEPT_TITLE �μ���, COUNT(*) �ο���, SUM(SALARY) �޿��հ�, AVG(SALARY) �޿����
SELECT NATIONAL_NAME ������, 
        DEPT_TITLE �μ���, 
        COUNT(*) "�ο���", 
        TO_CHAR(SUM(SALARY), '999,999,999') "�޿��հ�", 
        TO_CHAR(ROUND(AVG(SALARY)), '999,999,999') "�޿����"
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN LOCATION L ON (D.LOCATION_ID = LOCAL_CODE)
LEFT JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
GROUP BY NATIONAL_NAME, DEPT_TITLE
ORDER BY NATIONAL_NAME, DEPT_TITLE DESC;




-- 10�� ����
-- ��ǥ '������'�� �ֱ� �系���� �������� �ǽɵǴ� ��Ȳ�� ����� �Ǿ���.
-- ������ ã�Ƴ��� ���� �������� ���翡�� ��и��� ������� ������ �����ؿ���� ����ߴ�.
-- ���, �����, �μ���, ���޸�, �޿�, ���ʽ�, ����, ������� ��ȸ�ϰ�
-- ������ ����� ��������, �޿� �������� ������ �����Ѵ�.
-- ������� �ֹι�ȣ ���ڸ� 2��°���� 2�ڸ��� �������� ������ ����.
--���� 00~08 / �λ� 09~12 / ��õ 13~15 / ��� 16~25 / ���� 26~34 / ��� 35~39 / ���� 40 /
--�泲 41~47 / ���� 48~54 / ���� 55~64 / ���� 65~66 / �뱸 67~69, 76 /
--��� 70~75, 77~81 / �泲 82~84, 86~92 / ��� 85 / ���� 93~95 / �� �ܿ��� 'Ȯ�ο��'���� ǥ��
SELECT EMP_ID ���, EMP_NAME �����, DEPT_TITLE �μ���, JOB_NAME ���޸�, SALARY �޿�, BONUS ���ʽ�, 
       DECODE(SUBSTR(EMP_NO, 8, 1), 1, '��', 2, '��') ����, 
       CASE 
       WHEN '00' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '08' THEN '����'
       WHEN '09' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '12' THEN '�λ�'
       WHEN '13' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '15' THEN '��õ'
       WHEN '16' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '25' THEN '���'
       WHEN '26' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '34' THEN '����'
       WHEN '35' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '39' THEN '���'
       WHEN SUBSTR(EMP_NO, 9, 2) = '40' THEN '����'
       WHEN '41' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '47' THEN '�泲'
       WHEN '48' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '54' THEN '����'
       WHEN '55' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '64' THEN '����'
       WHEN '65' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '66' THEN '����'
       WHEN '67' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '69'
         OR SUBSTR(EMP_NO, 9, 2) = '76'  THEN '�뱸'
       WHEN '70' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '75' 
         OR '77' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '81' THEN '���'
       WHEN '82' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '84' 
         OR '86' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '92' THEN '�泲'
       WHEN SUBSTR(EMP_NO, 9, 2) = '85' THEN '���'
       WHEN '93' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '95' THEN '���'
       ELSE 'Ȯ�ο��'
       END �����
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = DEPT_ID) --LEFT������ �� ���� -> �μ��� NULL�� �̿���, �ϵ��� ����
ORDER BY ����� ASC, SALARY DESC;