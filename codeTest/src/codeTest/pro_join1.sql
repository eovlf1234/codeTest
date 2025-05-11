-- join (특정 기간동안 대여 가능한 자동차들의 대여비용 구하기)

select c.car_id, c.car_type, truncate((c.daily_fee * ((100 - p.discount_rate) / 100)) * 30, 0) as fee
from (select *
        from car_rental_company_car
       where car_type in ('세단','suv')) c
join (select *
        from car_rental_company_rental_history
       where car_id not in (select car_id
                           from car_rental_company_rental_history
                          where start_date <= '2022-11-30' and end_date >= '2022-11-01')) h on c.car_id = h.car_id
join (select *
        from car_rental_company_discount_plan
       where duration_type = '30일 이상') p on c.car_type = p.car_type
where (c.daily_fee * ((100 - p.discount_rate) / 100)) * 30 between '500000' and '1999999'
group by c.car_id
order by fee desc, car_type, car_id;

-- from절에서 join을 할 때 성능을 위해 서브쿼리문으로 작성하였는데
-- 서브쿼리로 작성하다보니 가독성이 좀 떨어지는 것 같음
-- 일정부분만 서브쿼리를 사용하던가 해서 가독성을 올리는게 좋을 것 같음
-- 11-01 ~ 11-30 까지를 구하는 것에 시간이 너무 많이 사용됨
-- 11-01 ~ 11-30까지만 start와 end에 들어가면 된다고 생각했는데
-- 11월 이전과 11월 이후기간 동안 사용기록이 있으면 이 또한 제외되어야 했는데
-- 생각하지 못함.
-- 결국 11-30 이전에 시작되고 11-01 이후에 종료되는 조건을 통해 올바른 경우를 찾아냄
-- (chatgpt의 도움 받음)
-- discount에서도 처음에 문제를 보고 %가 있는줄 알고 여러가지 식을 썼었는데 결과를 보니
-- %는 없고 할인율 숫자만 있었음.. 다음부터 sql 결과문을 제대로 봐야겠음!