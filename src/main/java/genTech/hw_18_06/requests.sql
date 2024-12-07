-- Вывести страны, в которых ко-во клиентов от 10 до 20 (вкл.)

SELECT Country
FROM Customers
Group By Customers.Country
HAVING COUNT(*) BETWEEN 10 AND 20;

-- Вывести ТОП-3 стран по ко-ву клиентов

SELECT Country
FROM Customers
Group By Customers.Country
ORDER By COUNT(*) DESC LIMIT 3;

-- Вывести имена клиентов, у которых два и более заказов

SELECT CustomerName
FROM Customers
         JOIN Orders ON Orders.CustomerID = Customers.CustomerID
GROUP BY Orders.CustomerID
HAVING COUNT(*) >= 2;