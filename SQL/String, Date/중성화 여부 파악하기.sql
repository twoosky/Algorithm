SELECT ANIMAL_ID, NAME, 
    IF (SEX_UPON_INTAKE LIKE 'Neutered%' or SEX_UPON_INTAKE LIKE 'Spayed%', 'O', 'X') AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

-- <IF>
-- IF(조건, 참일때의 값, 거짓일때의 값)
-- SELECT 할 컬럼 리스트에 IF 넣음