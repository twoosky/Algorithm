SELECT ANIMAL_ID, NAME, LEFT(DATE(DATETIME), 10) AS 날짜
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

-- <문자열 자르기>
-- LEFT(문자열, 길이) : 왼쪽부터 원하는 길이만큼 자르는 함수
-- RIGHT(문자열, 길이) : 오른쪽부터 원하는 길이만큼 자르는 함수
-- SUBSTRING(문자열, 시작자리번호, 자를문자수) : 일정한 영역만큼 자르는 함수
-- 참고 : https://coding-factory.tistory.com/99