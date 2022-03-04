SELECT name
from animal_ins
order by datetime
limit 1

--- <LIMIT>
--- 특정 개수의 row 조회
--- ex) SELECT * FROM ANIMAL_INS LIMIT 5
--- 상위 5개의 row만 가져온다.

select name
from animal_ins
where datetime =
    (select min(datetime)
     from animal_ins)

