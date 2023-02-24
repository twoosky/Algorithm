select truncate(price / 10000, 0) * 10000 as price_group, count(price) as product
from product
group by price_group
order by price_group