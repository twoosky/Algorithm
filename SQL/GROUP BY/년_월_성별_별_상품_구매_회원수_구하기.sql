SELECT year(sales_date) as year, month(sales_date) as month, gender, count(distinct a.user_id) as users
from user_info a inner join online_sale b
on a.user_id = b.user_id
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year, month, gender

-- 년, 월, 성별 별로 상품을 구매한 '회원수'이므로 회원 id 중복 제거한 뒤 회원 수 세야됨
-- count(distinct a.user_id)