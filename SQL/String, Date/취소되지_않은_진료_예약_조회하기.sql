SELECT a.apnt_no, c.pt_name, c.pt_no, b.mcdp_cd, b.dr_name, a.apnt_ymd
from appointment a inner join doctor b inner join patient c
                                                  on a.pt_no = c.pt_no and a.mddr_id = b.dr_id
where month(a.apnt_ymd) = 4 and day(a.apnt_ymd) = 13
  and a.apnt_cncl_yn = 'N' and a.mcdp_cd = 'CS'
order by a.apnt_ymd