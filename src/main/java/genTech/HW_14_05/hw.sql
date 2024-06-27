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