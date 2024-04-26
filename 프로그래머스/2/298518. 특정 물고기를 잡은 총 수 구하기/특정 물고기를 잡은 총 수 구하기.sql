-- 코드를 작성해주세요
SELECT SUM(FC.FISH_COUNT) AS FISH_COUNT 
FROM 
(SELECT COUNT(FI.ID) AS FISH_COUNT
FROM FISH_INFO FI
LEFT JOIN FISH_NAME_INFO FN
ON FI.FISH_TYPE = FN.FISH_TYPE
WHERE FN.FISH_NAME = 'BASS' OR FN.FISH_NAME = 'SNAPPER'
GROUP BY FN.FISH_TYPE) FC