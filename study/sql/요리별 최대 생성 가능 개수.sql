SELECT f.음식, MIN(COALESCE(FLOOR(i.양 / f.필요한수량), 0)) AS 최대_제작_가능_개수
FROM 음식 f
RIGHT OUTER JOIN 재료 i 
ON f.재료이름 = i.재료이름
GROUP BY f.음식;
