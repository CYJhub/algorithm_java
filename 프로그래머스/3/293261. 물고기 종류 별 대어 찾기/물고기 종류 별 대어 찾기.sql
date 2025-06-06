SELECT FISH_LEN.ID, FISH_NAME_INFO.FISH_NAME, FISH_LEN.LENGTH
FROM FISH_NAME_INFO, (SELECT FISH_INFO.ID, FISH_INFO.FISH_TYPE, FISH_INFO.LENGTH
FROM FISH_INFO, (SELECT FISH_TYPE, MAX(LENGTH) AS MAXL
     FROM FISH_INFO
     GROUP BY FISH_TYPE) MAX_LEN 
WHERE FISH_INFO.FISH_TYPE = MAX_LEN.FISH_TYPE AND FISH_INFO.LENGTH=MAX_LEN.MAXL) FISH_LEN
WHERE FISH_NAME_INFO.FISH_TYPE = FISH_LEN.FISH_TYPE 
ORDER BY FISH_LEN.ID;
