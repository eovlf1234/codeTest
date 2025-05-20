select round(avg(daily_fee),0) as AVERAGE_FEE
from car_rental_company_car
where car_type = 'SUV'

-- round 함수가 안 외워진다..
-- round = 반올림
-- floor = 버림
-- ceiling = 올림