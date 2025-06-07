select member_name, review_text, date_format(review_date, '%Y-%m-%d') as review_date
from member_profile p join rest_review r on p.member_id = r.member_id
where p.member_id in (select member_id
                     from rest_review
                    group by member_id
                   having count(*) = (select max(r_cnt)
                                        from (select count(*) as r_cnt
                                                from rest_review
                                               group by member_id) a))
order by review_date, review_text

-- 처음에 몇 번 구문을 짜봤을 때
-- 서브쿼리가 너무 많이 나올 것 같아서 쉽게 해보려고
-- 이것저것 써봤음 이 과정에서 많은 시간을 썼지만
-- 결국 여러 개의 서브쿼리를 써야겠다고 생각하고 구문을 작성함
-- 서브쿼리를 여러 개 작성하고 작성한 결과 빠르게 짤 수 있었음
-- 이 코드를 가지고 chatgpt를 통해 간결화를 물어보니
-- where절에서 조건을 주지 않고 join을 max값에 해당하는 id를 찾고
-- 이를 통해 on 조건절에서 id에 해당하는 결과를 가져와 더 쉽게
-- 결과물을 얻는 방법에 대해 알게 되었음
-- ----------------------------------------------------
-- JOIN (
--    SELECT member_id
--    FROM rest_review
--    GROUP BY member_id
--    ORDER BY COUNT(*) DESC
--    LIMIT 1
-- ) top_member ON r.member_id = top_member.member_id