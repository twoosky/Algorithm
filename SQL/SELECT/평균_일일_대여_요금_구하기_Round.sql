SELECT round(sum(daily_fee)/count(*)) as AVERAGE_FEE
from car_rental_company_car as c
where c.car_type = 'SUV';