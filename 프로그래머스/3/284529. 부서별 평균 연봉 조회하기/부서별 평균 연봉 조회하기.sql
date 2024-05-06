-- 코드를 작성해주세요
SELECT E.DEPT_ID, D.DEPT_NAME_EN, ROUND(AVG(E.SAL), 0) AS AVG_SAL
FROM HR_EMPLOYEES E
LEFT JOIN HR_DEPARTMENT D
ON D.DEPT_ID = E.DEPT_ID
GROUP BY E.DEPT_ID
ORDER BY AVG_SAL DESC