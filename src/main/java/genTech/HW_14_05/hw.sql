
-- Вывести заказы со стоимостью от 5000 и более EUR (проекция: номер_заказа, стоимость_заказа)

SELECT Orders.OrderID, SUM(Products.Price * OrderDetails.Quantity) AS OrderPrice
FROM Orders
         JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
         JOIN Products ON OrderDetails.ProductID = Products.ProductID
GROUP BY Orders.OrderID
HAVING OrderPrice > 5000;

-- Вывести страны, в которые было отправлено 3 и более заказов

SELECT Customers.Country
FROM Orders
         JOIN Customers ON Orders.CustomerID = Customers.CustomerID
GROUP BY Customers.Country
HAVING COUNT(*) > 3;

-- Вывести ТОП-10 самых продаваемых товаров (проекция: название_товара, ко_во_проданных_единиц)

SELECT Products.ProductName, SUM(Products.Price * OrderDetails.Quantity) AS TotalPrice
FROM Products
         JOIN OrderDetails ON OrderDetails.ProductID = Products.ProductID

GROUP BY Products.ProductID
ORDER BY TotalPrice DESC LIMIT 10;

-- Расчитать З/П менеджеров (ставка - 5% от суммы проданных заказов)

SELECT Employees.LastName, SUM(Products.Price * OrderDetails.Quantity) * 0.05 AS Salary
FROM Products

         JOIN OrderDetails ON OrderDetails.ProductID = Products.ProductID
         JOIN Orders ON OrderDetails.OrderID = Orders.OrderID
         JOIN Employees ON Employees.EmployeeID = Orders.EmployeeID

GROUP BY Employees.EmployeeID;

-- Вывести общее ко-во поставщиков не из UK и не из China
SELECT COUNT(*) AS total FROM Suppliers
WHERE Country != "UK" && Country != "China";
-- Вывести среднюю/MAX/MIN стоимости и ко-во товаров из категорий 3 и 5
SELECT
    COUNT(*) AS Total,
    AVG(Price) AS Avg,
MIN(Price) AS Min,
MAX(Price) AS Max
FROM Products
WHERE CategoryID IN (3, 5);
-- Вывести общую сумму проданных товаров
SELECT SUM(Products.Price * OrderDetails.Quantity) FROM OrderDetails
JOIN Products ON OrderDetails.ProductID = Products.ProductID;
-- Вывести данные о заказах (номер заказа, имяклиента,
-- страна клиента, фамилия менеджера, название компанииперевозчика)
SELECT
    Orders.OrderID,
    Customers.CustomerName,
    Customers.Country,
    Employees.LastName,
    ShippersShipperName
FROM Orders
         JOIN Customers ON Orders.CustomerID = Customers.CustomerID
         JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
         JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID;
-- Вывести сумму, на которую было отправлено товаров клиентам в Germany

SELECT SUM(Products.Price * OrderDetails.Quantity) FROM Orders
JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
JOIN Products ON OrderDetails.ProductID = Products.ProductID
JOIN Customers ON Customers.CustomerID = Orders.CustomerID
WHERE Customers.Country != "Germany";

