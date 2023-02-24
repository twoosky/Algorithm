-- 내 풀이
SELECT category, price as max_price, product_name
from food_product a
where category in ('과자', '국', '김치', '식용유')
  and price = (
      select max(price)
      from food_product b
      where a.category = b.category
  )
order by price desc

-- 다른 사람 풀이
SELECT CATEGORY, PRICE MAX_PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE PRICE IN
      (
          SELECT MAX(PRICE) MAX_PRICE
          FROM FOOD_PRODUCT
          GROUP BY CATEGORY
      )
  AND CATEGORY IN ('과자', '국', '김치', '식용유')
ORDER BY 2 DESC

