-- 코드를 작성해주세요
SELECT CONCAT(QUARTER(DIFFERENTIATION_DATE) ,'Q') AS QUARTER,
COUNT(E.ID) AS ECOLI_COUNT
FROM ECOLI_DATA E
GROUP BY QUARTER
ORDER BY QUARTER