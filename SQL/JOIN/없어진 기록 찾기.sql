SELECT O.animal_id, O.name
from animal_ins as I right outer join animal_outs as O
    on I.animal_id = O.animal_id
where I.animal_id is null
order by O.animal_id

-- <INNER JOIN>
-- <LEFT OUTER JOIN>
-- <RIGHT OUTER JOIN>
-- <OUTER JOIN>
-- 참고 : https://pearlluck.tistory.com/46
-- 공책 참고