SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') AS OUT_DATE,
CASE 
    WHEN OUT_DATE <= '2022-05-01' THEN "출고완료"
    WHEN OUT_DATE > '2022-05-01' THEN "출고대기"
    WHEN OUT_DATE is NULL THEN "출고미정"
END AS '출고여부'
FROM FOOD_ORDER
ORDER BY 1;

-- 2022-05-01 보다 작거나 같으면 "출고완료"
-- 크면 "출고대기"
-- outdate 값이 null이면 "출고미정"
