package ua.com.antivirus.dao;

import java.time.LocalDate;
import java.util.List;

import ua.com.antivirus.entity.Orders;
import ua.com.antivirus.entity.Product;
import ua.com.antivirus.entity.User;

public interface OrdersDao {
	void save(Orders orders, User user, Product drink);
	List<Orders> findAll();
	Orders findOne(LocalDate date);
	void delete(LocalDate date);
	void update(Orders orders);
	
	void addUserToOrders(User user, Orders orders);
	void addDrinkToOrder(Product drink, Orders orders);
	
	Orders findOrderWithDrinks(LocalDate date);

}
