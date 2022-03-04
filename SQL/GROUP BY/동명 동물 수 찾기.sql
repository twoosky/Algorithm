SELECT distinct name, count(name) as count
from animal_ins
group by name
having count(name) >= 2
order by name

-- <DISTINCT>
-- null을 포함하지 않고, 중복 제거
-- name 앞에 distinct를 붙여 null인 이름 제외