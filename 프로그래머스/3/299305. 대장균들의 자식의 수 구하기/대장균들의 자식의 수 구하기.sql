-- 코드를 작성해주세요
SELECT F.ID, COUNT(S.PARENT_ID) AS CHILD_COUNT
FROM ECOLI_DATA F
LEFT JOIN ECOLI_DATA S
ON F.ID = S.PARENT_ID
GROUP BY F.ID