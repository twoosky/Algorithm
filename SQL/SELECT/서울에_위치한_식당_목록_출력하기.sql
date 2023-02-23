select a.REST_ID, b.REST_NAME, b.FOOD_TYPE, b.FAVORITES, b.ADDRESS,
       round(avg(a.review_score), 2) as SCORE
from rest_review a
         join rest_info b on a.rest_id = b.rest_id
group by a.rest_id
having b.address like '서울%'
order by score desc, b.favorites desc;