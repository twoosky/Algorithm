SELECT hour(datetime) as hour, count(hour(datetime)) as count
from animal_outs
group by hour(datetime)
having hour >= 9 and hour <= 19
order by hour

-- <DATETIME>
-- datetime 타입에서 일부 추출
-- 1) YEAR(datatime 타입 컬럼명): 연도 추출
-- 2) MONTH: 월 추출
-- 3) DAY: 일 추출
-- 4) HOUR: 시 추출
-- 5) MINUTE: 분 추출
-- 6) SECOND: 초 추출