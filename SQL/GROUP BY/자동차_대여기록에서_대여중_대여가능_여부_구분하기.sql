-- 내 풀이 (union 사용)
(
    SELECT car_id, '대여중' as availability
    from car_rental_company_rental_history
    where start_date < '2022-10-17' and end_date > '2022-10-15'
)
union
(
    SELECT car_id, '대여 가능' as availability
    from car_rental_company_rental_history
    where (start_date > '2022-10-17' or end_date < '2022-10-15')
      and car_id not in (
        SELECT car_id
        from car_rental_company_rental_history
        where start_date < '2022-10-17' and end_date > '2022-10-15'
    )
)
order by car_id desc

-- 다른 사람 풀이 (case 조건 사용)
select car_id,
       case
           when car_id in (
               select car_id
               from car_rental_company_rental_history
               where start_date < '2022-10-17' and end_date > '2022-10-15'
           ) then '대여중'
           else '대여 가능'
           end as availability
from car_rental_company_rental_history
group by car_id
order by car_id desc