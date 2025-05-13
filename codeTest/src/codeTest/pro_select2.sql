select f.flavor
from first_half f
join icecream_info i on f.flavor = i.flavor
where total_order > 3000 and ingredient_type = 'fruit_based';

-- 깔끔하게 코드를 작성하기 위해 이렇게 작성하였는데,
-- 성능을 고려하면 first_half를 서브쿼리에서 3000이상을 찾고
-- icecream_info를 ingredient_type이 과일인걸 찾아서
-- 두개를 조인하는게 좋을듯 함