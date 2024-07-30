-- цена от 200 EUR — наценка 0.5%
-- цена от 20 EUR — наценка 1.5%
SELECT *,
       CASE
           WHEN Price >= 200 THEN Price * 1.005
           WHEN Price >= 20 THEN Price * 1.015
           ELSE Price
           END AS Price_up

FROM Products
