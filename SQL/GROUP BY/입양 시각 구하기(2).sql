SET @hour := -1;

SELECT (@hour := @hour+1) as HOUR,
(SELECT COUNT(*)
 FROM animal_outs
 WHERE HOUR(datetime) = @hour) as COUNT
from animal_outs
where @hour < 23;

-- <SET>
-- 변수에 특정한 값 넣어줄 때 사용
-- 세미콜론 꼭 붙이기 !!!!!!!11
-- set할 때는 :=, = 모두 사용 가능 (단, 다른 연산은 := 만 사용 가능)
-- 참고: https://velog.io/@ljs7463/MySQL-%EC%9E%85%EC%96%91-%EC%8B%9C%EA%B0%81-%EA%B5%AC%ED%95%98%EA%B8%B02
