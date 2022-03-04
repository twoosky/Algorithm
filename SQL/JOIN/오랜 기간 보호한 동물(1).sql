SELECT I.name, I.datetime
from animal_ins as I LEFT OUTER JOIN animal_outs as O
    on I.animal_id = O.animal_id
where O.animal_id is null
order by I.datetime
limit 3