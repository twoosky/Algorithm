SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM animal_ins
where name = 'Lucy' or name = 'Ella' or name = 'Pickle'
    or name = 'Rogan' or name = 'Sabrina' or name = 'Mitty'
order by animal_id