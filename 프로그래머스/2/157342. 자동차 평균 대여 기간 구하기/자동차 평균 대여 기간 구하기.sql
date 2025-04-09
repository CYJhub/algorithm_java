SELECT CAR_ID, ROUND(AVG(AVG_DATE),1) AS AVERAGE_DURATION
FROM (SELECT CAR_ID, DATEDIFF(END_DATE,START_DATE) + 1 AS AVG_DATE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) AVG_RENT
GROUP BY CAR_ID
HAVING AVG(AVG_DATE) >= 7
ORDER BY 2 DESC, 1 DESC

