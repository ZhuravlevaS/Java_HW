-- Вывести данные о товарах (проекция: название, цена со скидкой 0.5 процента) по убыванию цены.
SELECT
    ProductName,
    Price * 0.995 AS DiscountPrice
FROM Products
ORDER BY Price DESC;
-- Вывести товары в диапазоне цены от 50 до 200 EUR (проекция: название, цена с наценкой 30 процентов) по возрастанию цены.
SELECT
    ProductName,
    Price * 1.3 AS HighPrice
FROM Products
WHERE Price BETWEEN 50 AND 200
ORDER BY Price
-- Вывести всех клиентов, кроме тех, что из USA и UK.
SELECT * FROM Customers
WHERE Country != "USA" AND Country != "UK";
-- Вывести товары из категорий 2 и 5 (проекция: всеимеющиесяполя, ценавдолларах)
SELECT *,
       Price*1.06 AS USDPrice
FROM Products
WHERE CategoryID in (2, 5);