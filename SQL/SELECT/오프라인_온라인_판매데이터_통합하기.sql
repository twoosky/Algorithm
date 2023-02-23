(SELECT date_format(sales_date, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
 from offline_sale
 where year(sales_date) = 2022 and month(sales_date) = 3)
union all
(SELECT date_format(sales_date, '%Y-%m-%d') as SALES_DATE, PRODUCT_ID, 	USER_ID, SALES_AMOUNT
 from online_sale
 where year(sales_date) = 2022 and month(sales_date) = 3)
order by sales_date, product_id, user_id;

-- NULL as USER_ID 로 해야됨
-- 'NULL' as USER_ID 로 하면 안된다!