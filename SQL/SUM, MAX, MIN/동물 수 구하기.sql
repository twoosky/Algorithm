SELECT count(distinct name) as count
from animal_ins

--- <count()>
--- 데이터 개수, 카운트
--- 1) select count(*) from 테이블
--- 2) select count(컬럼) from 테이블
--- 3) select count(컬럼) as 컬럼명 from 테이블
--- 위에서부터 각각 전체 개수, 특정 cloumn의 개수,
--- 세번째는 count값을 나타낼 컬럼명 지정

--- <DISTINCT>
--- 중복 제거 + 카운팅
--- ex) select count(distinct name) as 컬럼명 from 테이블