-- 코드를 입력하세요
SELECT P.PRODUCT_ID, P.PRODUCT_NAME, (P.PRICE * SUM(O.AMOUNT)) AS 'TOTAL_SALES'
FROM FOOD_PRODUCT P
LEFT JOIN FOOD_ORDER O
ON P.PRODUCT_ID = O.PRODUCT_ID
WHERE DATE_FORMAT(O.PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY P.PRODUCT_ID
ORDER BY (P.PRICE * SUM(O.AMOUNT))  DESC, P.PRODUCT_ID;

# SELECT * FROM FOOD_PRODUCT P
# LEFT JOIN FOOD_ORDER O
# ON P.PRODUCT_ID = O.PRODUCT_ID
# WHERE DATE_FORMAT(O.PRODUCE_DATE, '%Y-%m') = '2022-05'