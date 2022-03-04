SELECT I.animal_id, I.name
from animal_ins as I inner join animal_outs as O
    on I.animal_id = O.animal_id
where I.datetime > O.datetime
order by I.datetime

-- <INNER JOIN> 
-- * 컬럼값이 같은 튜플만 합침
-- <LEFT OUTER JOIN> 
-- * 왼쪽 테이블에서 오른쪽 테이블과 컬럼값이 같은 튜플은 합치고,
--   왼쪽 테이블에서 컬럼값이 같지 않은 튜플은  오른쪽 테이블의 컬럽값으로 NULL을 가짐
-- <RIGHT OUTER JOIN>
-- * 오른쪽 테이블에서 왼쪽 테이블과 컬럼값이 같은 튜플은 합치고, 
--   오른쪽 테이블에서 컬럼값이 같지 않은 튜플은 왼쪽 테이블의 컬럼값으로 NULL을 가짐 
-- <OUTER JOIN>
-- * 두 테이블에서 컬럼값이 같은 튜플은 합치고,
--   컬럼값이 같지 않은 튜플은 다른 테이블의 컬럼값으로 NULL을 가짐