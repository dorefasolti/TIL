-- 1번 문제
--부서별로 그룹하여 부서번호, 인원수, 급여의 평균, 급여의 합을 조회하세요.
    SELECT NVL(DEPT_CODE, '무소속') 부서번호, COUNT(*) 인원수, ROUND(AVG(SALARY)) 급여평균, SUM(SALARY) 급여햡
    FROM EMPLOYEE
    GROUP BY DEPT_CODE;
    
    
    
    
    
-- 2번 문제
-- 자신이 속한 직급의 평균 급여보다 많이 받는 사원의 이름, 직급명, 급여 정보 조회하세요.
SELECT EMP_NAME 이름, JOB_NAME 직급명, SALARY 급여
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE SALARY > (SELECT ROUND(AVG(SALARY))
                FROM EMPLOYEE EMP
                WHERE E.JOB_CODE = EMP.JOB_CODE
                GROUP BY JOB_CODE);
                
                
                
                
                
-- 3번 문제
-- 회사에서 휴가철을 맞아 전 사원에게 해외여행을 보내주려고 합니다.
-- 사원들의 급여에 맞춰 보내주려고 하여
-- S1,S2 인 사원들은 미국, S3, S4인 사원들은 중국, S5, S6인 사원들은 일본에 보내려고해요.
-- 단, 현재 근무하고 있는 지부의 국가가 해외여행을 보내주려는 국가와 같을 경우, 국내여행을 보내주며
-- 대표는 휴가때도 계속해서 근무를 하기로 합니다.
-- EMPLOYEE 테이블에서 이와 같은 조건에 맞는
-- 사번, 사원명, 부서명, 지부국가명(NATIONAL_NAME), 급여등급, 휴가여행지 를 사번 오름차순으로 조회하세요.
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_NAME 지부국가명, SAL_LEVEL 급여등급, 
    CASE
        WHEN JOB_CODE = 'J1' THEN '근무'
        WHEN SAL_LEVEL IN ('S1', 'S2') AND NATIONAL_NAME = '미국' THEN '국내여행'  --> 이게 앞으로 와야함 WHY ? 안그러면 S1S2에서 다 걸러져버림
        WHEN SAL_LEVEL IN ('S1', 'S2') THEN '미국'
        WHEN SAL_LEVEL IN ('S3', 'S4') AND NATIONAL_NAME = '중국' THEN '국내여행'
        WHEN SAL_LEVEL IN('S3', 'S4') THEN '중국'
        WHEN SAL_LEVEL IN ('S5', 'S6') AND NATIONAL_NAME = '일본' THEN '국내여행'
        WHEN SAL_LEVEL IN ('S5', 'S6') THEN '일본'
    END 휴가여행지
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
LEFT JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
ORDER BY EMP_ID;





-- 4번 문제
--모든 사원들 급여의 총합을 '￦00,000,000'형식으로 구하세요
SELECT TO_CHAR(SUM(SALARY),'L999,999,999')급여총합
FROM EMPLOYEE;





-- 5번 문제
--부서 코드가 D9인 사원들의 급여 중 최저 급여보다 높은 급여를 받는 사원의 이름과 급여를 출력하세요
SELECT EMP_NAME 이름, SALARY 급여
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9' AND SALARY > (SELECT MIN(SALARY)
                                        FROM EMPLOYEE);
                                        
                                        
                                        
                                  
-- 6번 문제
--'D6'번 부서의 사원 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 출력해보세요.
SELECT EMP_NAME 이름, SALARY 급여
FROM EMPLOYEE
WHERE SALARY > (SELECT MAX(SALARY)
                FROM EMPLOYEE
                WHERE DEPT_CODE = 'D6');                                        
                
                
                
                
                
-- 7번 문제
-- 회사의 재정난으로 인하여 구조조정이 불가피해졌습니다.
-- 우선 현재 사원을 파악하기 위해 (EMPLOYEE 테이블의) 모든 직원의 사번, 사원명, 직급, 부서명, 근무지역을
-- 직급코드와 사번의 내림차순으로 조회하세요.
SELECT EMP_ID 사번, EMP_NAME 사원명, J.JOB_NAME 직급명, D.DEPT_TITLE 부서명, L.LOCAL_NAME 지역명
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
ORDER BY E.JOB_CODE, EMP_ID DESC;






-- 8번 문제
-- 사기 충전의 의미로 한달에 한번 사내 이벤트가 진행됩니다.
-- 랜덤 추첨을 통한 이벤트 당첨자 발표를 위해 다음을 조회하세요. (사원 정보는 최소한만 노출되게 하기 위해 다음 조건을 만족해야 합니다)
-- 당첨자의 사번, 사원명(가운데 글자는 '*'으로 표시), 아이디(이메일에서 아이디만 추출), 연락처(가운데 4자리는 '****'으로 표시)
-- 이번 달 당첨자는 주민번호 마지막 자리가 '1'인 사원들입니다.
SELECT EMP_ID 사번,
    SUBSTR(EMP_NAME, 1, 1)||LPAD('*', LENGTH(EMP_NAME) -2)||SUBSTR(EMP_NAME, 3) 사원명,
       SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 아이디,
       NVL(SUBSTR(PHONE, 1, 3)||LPAD('*', LENGTH(PHONE) -7, '*')||SUBSTR(PHONE, 8, 5), '없음') 연락처
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 14, 1) = 1;




-- 9번 문제
-- 국가명, 부서명, 인원수, 급여합계, 급여평균을 조회하되,
-- 국가명과 부서명 별로 묶어서 조회하고,
-- 정렬은 국가명 내림차순, 부서명 내림차순 순서로 지정하세요.
--, DEPT_TITLE 부서명, COUNT(*) 인원수, SUM(SALARY) 급여합계, AVG(SALARY) 급여평균
SELECT NATIONAL_NAME 국가명, 
        DEPT_TITLE 부서명, 
        COUNT(*) "인원수", 
        TO_CHAR(SUM(SALARY), '999,999,999') "급여합계", 
        TO_CHAR(ROUND(AVG(SALARY)), '999,999,999') "급여평균"
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
LEFT JOIN LOCATION L ON (D.LOCATION_ID = LOCAL_CODE)
LEFT JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
GROUP BY NATIONAL_NAME, DEPT_TITLE
ORDER BY NATIONAL_NAME, DEPT_TITLE DESC;




-- 10번 문제
-- 대표 '선동일'은 최근 사내에서 지연으로 의심되는 상황을 엿듣게 되었다.
-- 누군지 찾아내기 위해 믿을만한 김기사에게 비밀리에 사원들의 정보를 정리해오라고 명령했다.
-- 사번, 사원명, 부서명, 직급명, 급여, 보너스, 성별, 출생지를 조회하고
-- 정렬은 출생지 오름차순, 급여 내림차순 순서로 정렬한다.
-- 출생지는 주민번호 뒷자리 2번째부터 2자리를 기준으로 다음과 같다.
--서울 00~08 / 부산 09~12 / 인천 13~15 / 경기 16~25 / 강원 26~34 / 충북 35~39 / 대전 40 /
--충남 41~47 / 전북 48~54 / 전남 55~64 / 광주 65~66 / 대구 67~69, 76 /
--경북 70~75, 77~81 / 경남 82~84, 86~92 / 울산 85 / 제주 93~95 / 그 외에는 '확인요망'으로 표시
SELECT EMP_ID 사번, EMP_NAME 사원명, DEPT_TITLE 부서명, JOB_NAME 직급명, SALARY 급여, BONUS 보너스, 
       DECODE(SUBSTR(EMP_NO, 8, 1), 1, '남', 2, '여') 성별, 
       CASE 
       WHEN '00' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '08' THEN '서울'
       WHEN '09' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '12' THEN '부산'
       WHEN '13' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '15' THEN '인천'
       WHEN '16' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '25' THEN '경기'
       WHEN '26' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '34' THEN '강원'
       WHEN '35' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '39' THEN '충북'
       WHEN SUBSTR(EMP_NO, 9, 2) = '40' THEN '대전'
       WHEN '41' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '47' THEN '충남'
       WHEN '48' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '54' THEN '전북'
       WHEN '55' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '64' THEN '전남'
       WHEN '65' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '66' THEN '광주'
       WHEN '67' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '69'
         OR SUBSTR(EMP_NO, 9, 2) = '76'  THEN '대구'
       WHEN '70' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '75' 
         OR '77' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '81' THEN '경북'
       WHEN '82' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '84' 
         OR '86' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '92' THEN '경남'
       WHEN SUBSTR(EMP_NO, 9, 2) = '85' THEN '울산'
       WHEN '93' <= SUBSTR(EMP_NO, 9, 2) AND SUBSTR(EMP_NO, 9, 2) <= '95' THEN '경북'
       ELSE '확인요망'
       END 출생지
FROM EMPLOYEE E
LEFT JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE = DEPT_ID) --LEFT조인을 한 이유 -> 부서명 NULL인 이오리, 하동운 누락
ORDER BY 출생지 ASC, SALARY DESC;