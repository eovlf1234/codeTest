select i.rest_id,
       i.rest_name,
       i.food_type,
       i.favorites,
       i.address,
       round(r.score, 2) as score
from rest_info i
join (select rest_id, avg(review_score) as score
        from rest_review
    group by rest_id) r on i.rest_id = r.rest_id
where address like '서울%'
order by score desc, favorites desc;

-- 반올림하는 함수가 생각나지 않았음..
-- 반올림 = round