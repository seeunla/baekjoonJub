-- 코드를 작성해주세요
SELECT SUM(HG.SCORE) AS SCORE, HG.EMP_NO, HE.EMP_NAME, HE.POSITION, HE.EMAIL
FROM HR_EMPLOYEES HE
LEFT JOIN HR_GRADE HG
ON HE.EMP_NO = HG.EMP_NO
# WHERE 
GROUP BY HE.EMP_NO
ORDER BY SCORE DESC
LIMIT 1
# (SELECT S.EMP_NO FROM
#  (SELECT SUM(SCORE) AS SCORE, EMP_NO FROM HR_GRADE GROUP BY EMP_NO ORDER BY SCORE DESC LIMIT 1) S ) A