select a.author_id, author_name, category, sum(sales * price) as total_sales
from book a inner join author b
            inner join (
    select book_id, sum(sales) as sales
    from book_sales
    where year(sales_date) = 2022 and month(sales_date) = 1
    group by book_id
) c
                       on a.author_id = b.author_id and a.book_id = c.book_id
group by a.category, a.author_id
order by a.author_id, category desc