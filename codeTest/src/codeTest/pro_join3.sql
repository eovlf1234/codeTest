select p.product_id, p.product_name, sum(amount) * price as total_sales
from food_product p
join (select *
        from food_order
       where produce_date like "2022-05%") o on p.product_id = o.product_id
group by product_id
order by total_sales desc, product_id asc

-- 딱히 어려움 없이 풀었땅..