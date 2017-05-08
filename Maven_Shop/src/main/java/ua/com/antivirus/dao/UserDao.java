package ua.com.antivirus.dao;

import java.util.List;

import ua.com.antivirus.entity.Orders;
import ua.com.antivirus.entity.User;

public interface UserDao {
	
	void save(User user);
	List<User> findAll();
	User findOne(String name);
	void delete(String name, String email); 
	void update(User user); 
	void addOrderToUser(User user, Orders orders);
	
}
