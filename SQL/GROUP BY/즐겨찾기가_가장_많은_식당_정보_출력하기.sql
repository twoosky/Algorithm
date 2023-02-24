select food_type, rest_id, rest_name, favorites
from rest_info a
where favorites = (
    SELECT max(favorites)
    from rest_info b
    where a.food_type = b.food_type
)
order by food_type desc