SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE,"%Y-%m-%d") as PUBLISHED_DATE
FROM BOOK B
JOIN AUTHOR A
ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE B.CATEGORY = '경제' 
ORDER BY B.PUBLISHED_DATE;