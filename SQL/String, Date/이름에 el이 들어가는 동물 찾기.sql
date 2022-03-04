SELECT ANIMAL_ID, NAME
FROM animal_ins
where name like '%el%' and animal_type = 'Dog'
order by name