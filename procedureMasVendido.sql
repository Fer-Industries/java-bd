DELIMITER //
	Create procedure masVendido (in anio_solicitado int)
		begin 
			select ot.ProductID, p.productname, sum(quantity) as cantidad
			from orderdetails ot inner join orders o on ot.OrderID = o.OrderID
			inner join products p on ot.ProductID = p.ProductID
			WHERE year (orderdate) = anio_solicitado
			group by ot.ProductID,p.productname
			HAVING 
			sum(quantity)=
			(Select Max(cantidad) from (select ProductID, sum(quantity) as cantidad
			from orderdetails ot inner join orders o on ot.OrderID = o.OrderID
			WHERE year (orderdate) = anio_solicitado
			group by ProductID) c);
		end
//