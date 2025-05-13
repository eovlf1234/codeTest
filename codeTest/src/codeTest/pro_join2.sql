select flavor
from(
    select f.flavor, (f.total_order + j.total) as total_order
    from first_half f
    join (select flavor, sum(total_order) as total
    from july
    group by flavor) j on f.flavor = j.flavor
) t
order by total_order desc
limit 3;

-- join을 하고 두 테이블의 값을 합하여 값을 얻고 정렬하기 위해
-- join하여 합을 얻는 컬럼을 from절의 서브쿼리로 작성하고
-- from절을 내림차순으로 정렬하여 3개를 출력하는식으로 쿼리를 작성함
-- 이전에 작성한 식을 보니 서브쿼리를 사용하지 않고, join한 후
-- order by절에서 sum(total_order + total) desc를 통해
-- 정렬한 것을 볼 수 있었는데 이렇게 하는게 더 좋은 것 같음!!