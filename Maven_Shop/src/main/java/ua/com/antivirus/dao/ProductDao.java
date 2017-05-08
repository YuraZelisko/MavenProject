package ua.com.antivirus.dao;

import java.util.List;

import ua.com.antivirus.entity.Orders;
import ua.com.antivirus.entity.Product;

public interface ProductDao {

	void save(Product drink);
	List<Product> findAll();
	Product findOne(String name);
	void delete(String name); 
	void update(Product drink);
	void addDrinkToOrder(Product drink, Orders orders);

}
