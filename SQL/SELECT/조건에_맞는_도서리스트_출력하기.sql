SELECT book_id, date_format(published_Date, '%Y-%m-%d') as published_date
from book
where category = '인문' and year(published_Date) = '2021'
order by published_date;