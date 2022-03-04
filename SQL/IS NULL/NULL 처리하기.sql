SELECT animal_type, ifnull(name, "No name"), sex_upon_intake
from animal_ins
order by animal_id

-- <IFNULL>
-- 해당 필드값이 NULL이라면 다른 값을 반환하도록 해주는 함수
-- ex) SELECT IFNULL("컬럼명", "대체할 값") FORM "테이블명";
-- 해당 필드값이 null이면 대체값 출력
-- 해당 필드값이 null이 아니면 필드값 출력