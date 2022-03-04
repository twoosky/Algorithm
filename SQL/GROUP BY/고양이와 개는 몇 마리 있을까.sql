/* 
   동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 
   이때 고양이를 개보다 먼저 조회해주세요.
*/
SELECT animal_type, count(animal_type)
from animal_ins
group by animal_type
having animal_type = 'Cat' or animal_type = 'Dog'
order by animal_type

--- <HAVING>
--- 조건 조회, where에서는 사용할 수 없는 집계함수(count, min, max ..) 사용 가능
