SELECT animal_id, name
from animal_ins
where intake_condition = 'sick'
order by animal_id asc;

-- sql 세미콜론 붙여야됨
-- 근데 안붙여도 프로그래머스에서는 실행되네
-- order by는 맨 끝에 붙이면 됨