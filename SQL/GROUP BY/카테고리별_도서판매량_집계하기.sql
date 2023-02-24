SELECT category, sum(sales) as total_sales
from book b inner join book_sales bs
                       on b.book_id = bs.book_id
where year(bs.sales_date) = 2022 and month(bs.sales_date) = 1
group by category
order by category