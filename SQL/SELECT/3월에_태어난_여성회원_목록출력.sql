SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(date_of_birth, "%Y-%m-%d") as DATE_OF_BIRTH
from member_profile as m
where month(m.date_of_birth) = '3'
  and gender = 'W' and tlno is not NULL;