SELECT f.food, MIN(COALESCE(FLOOR(i.amount / f.required_quantity), 0)) AS max_producible_quantity
FROM food f
RIGHT OUTER JOIN ingredients i 
ON f.ingredient_name = i.ingredient_name
GROUP BY f.food;
