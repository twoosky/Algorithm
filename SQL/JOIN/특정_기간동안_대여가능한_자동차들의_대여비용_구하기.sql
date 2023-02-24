-- 내 풀이
SELECT company.car_id, company.car_type, round(company.daily_fee * discount.per * 30) as fee
from car_rental_company_car company
         inner join (
    select car_type, round((100 - discount_rate) / 100, 2) as per
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where duration_type like '30%'
      and (car_type = '세단' or car_type = 'SUV')) discount
                    on company.car_type = discount.car_type
where (company.car_type = 'SUV' or company.car_type = '세단')
  and (company.daily_fee * discount.per * 30) >= 500000
  and (company.daily_fee * discount.per * 30) < 2000000
  and company.car_id not in (
    select distinct car_id
    from car_rental_company_rental_history
    where start_date < '2022-12-01' and end_date > '2022-11-01'
)
order by fee desc, company.car_type, company.car_id desc;

-- 위에 쿼리 리팩토링한 버전
SELECT C.car_id, C.car_type, round(C.daily_fee * ((100 - D.discount_rate) / 100) * 30) as fee
from car_rental_company_car C
         inner join car_rental_company_discount_plan D
                    on C.car_type = D.car_type
where C.car_id not in (
    select distinct car_id
    from car_rental_company_rental_history
    where start_date < '2022-12-01' and end_date > '2022-11-01'
) and D.duration_type like '30%'
group by C.car_id
having C.car_type in ('SUV', '세단')
   and (fee >= 500000 and fee < 2000000)
order by fee desc, C.car_type, C.car_id desc;