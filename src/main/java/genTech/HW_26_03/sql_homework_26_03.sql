-- Вывести название и стоимость товаров от 20 до 150 EUR.
SELECT ProductName, Price FROM Products WHERE Price > 20 && Price < 150;
-- Вывести телефоны поставщиков из Japan и Spain.
SELECT Phone FROM Suppliers WHERE Country = 'Japan' || Country = 'Spain';
-- Вывести название и стоимость товаров от всех поставщиков, кроме поставщика 1.
SELECT ProductName, Price  FROM Products WHERE SupplierID != 1;
-- Вывести контактные имена клиентов, кроме тех, что из Germany и Brazil.
SELECT ContactName FROM Customers WHERE Country != 'Germany' && Country != 'Brazil';
-- Вывести товары с ценой от 50 до 100 EUR (вкл.)
SELECT * FROM Products WHERE Price >= 50 && Price <= 100;
-- Вывести название и стоимость товаров из категорий 1 и 3 со стоимостью до 50 EUR (вкл.)
SELECT ProductName, Price  FROM Products WHERE (CategoryID = 1 || CategoryID = 3) && Price <= 50;