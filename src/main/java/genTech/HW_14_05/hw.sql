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