SELECT animal_id
from animal_ins
where name is null
order by animal_id

-- <IS NULL>
-- null인 경우 조건
-- ex) where 필드명 is null
-- 해당 필드가 null인 경우