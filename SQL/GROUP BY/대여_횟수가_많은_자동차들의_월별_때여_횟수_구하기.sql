select month(start_date) as month, car_id, count(*) as records
from car_rental_company_Rental_history
where car_id in (
    select car_id
    from car_rental_company_rental_history
    where start_date > '2022-07-31' and start_date < '2022-11-01'
    group by car_id
    having count(*) >= 5
    ) and start_date > '2022-07-31' and start_date < '2022-11-01'
group by month(start_date), car_id
order by month(start_date), car_id desc

-- 날짜 조건 2번 확인하는 이유
-- (HISTORY_ID	CAR_ID	START_DATE	 END_DATE )
-- (    1	       1	2022-07-27	2022-08-02)
-- (    2	       1	2022-08-03	2022-08-04)
-- (    3	       1	2022-08-04	2022-08-07)
-- (    4	       1	2022-08-05	2022-08-08)
-- (    5	       1	2022-08-06	2022-08-09)


-- 서브쿼리에서 car_id(1) 데이터는 조건에 참이므로 결과테이블에 car_id 1이 포함될 것이다.
-- history_id(1)은 7월에 대여했으므로 결과에 포함되면 안된다.
-- 하지만 history_id(1)의 car_id는 1이기 때문에 where car_id in (서브쿼리 결과테이블) 조건에 참이 된다.
-- 따라서 날짜 조건을 2번 확인해 7월에 대여한 history는 걸러내야 한다!