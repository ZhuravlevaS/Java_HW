--  Дайте короткий ответ на вопрос: в чем отличие БД от СУБД
-- БД - это база данных, где хранятся данные
-- СУБД - это система управления базой данных

-- Вывести данные о товарах (проекция: название товара, цена, название категории, название компании поставщика)

SELECT ProductName, Price, Suppliers.SupplierName, Categories.CategoryName FROM Products
    JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID
    JOIN Categories ON Products.CategoryID = Categories.CategoryID;

-- Вывести список стран, которые поставляют морепродукты

SELECT Suppliers.Country FROM Products
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID
WHERE CategoryID IN (8);

-- Вывести два самых дорогих товара из категории Beverages(1) из USA

SELECT * FROM Products
JOIN Suppliers ON Products.SupplierID = Suppliers.SupplierID
WHERE CategoryID IN (1) AND Suppliers.Country = "USA"
ORDER BY Price DESC
LIMIT 2;

-- Вывести название и стоимость в USD одного самого дорогого проданного товара

SELECT Products.ProductName, Products.Price * 1.07 AS PriceUSD FROM OrderDetails
JOIN Products ON OrderDetails.ProductID = Products.ProductID
ORDER BY Products.Price DESC
LIMIT 1;