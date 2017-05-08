package ua.com.antivirus.daoImp;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import ua.com.antivirus.dao.OrdersDao;
import ua.com.antivirus.entity.Orders;
import ua.com.antivirus.entity.Product;
import ua.com.antivirus.entity.User;


public class OrderDaoImp implements OrdersDao{

	private final EntityManager entityManager;
	
	public OrderDaoImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void save(Orders orders, User user, Product drink) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(orders);
		
		orders.setUser(user);
		
		orders.getDrinks().add(drink);
		
		entityManager.merge(orders);
		
		
		entityManager.getTransaction().commit();
		
	}

	public List<Orders> findAll() {
		
		entityManager.getTransaction().begin();
		
		List<Orders> orders = entityManager.createQuery("from Orders").getResultList();
		
		entityManager.getTransaction().commit();
		
		return orders;
	}

	public Orders findOne(LocalDate date) {

		entityManager.getTransaction().begin();
		Orders orders = null;
		
		try{
		  orders = (Orders) entityManager
				.createQuery("select o from Orders o where o.date =:value")
				.setParameter("value", date)
				.getSingleResult();
		
		}catch (NoResultException e) {
			System.out.println(e.getMessage());
		}catch (NonUniqueResultException e) {
			System.out.println(e.getMessage());
		}
		entityManager.getTransaction().commit();
		
		
		return orders;
	}

	public void delete(LocalDate date) {
		
		Orders orders = findOne(date);
		
		entityManager.getTransaction().begin();
		
		entityManager.remove(orders);
		
		entityManager.getTransaction().commit();
		
	}

	public void update(Orders orders) {
		entityManager.getTransaction().begin();
		
		entityManager.merge(orders);
		
		entityManager.getTransaction().commit();
		
	}

	public void addUserToOrders(User user, Orders orders) {
		 
		entityManager.getTransaction().begin();
		
//		user.getOrders().add(orders);
		orders.setUser(user);
		
		entityManager.getTransaction().commit();
		
	}

	public void addDrinkToOrder(Product product, Orders orders) {
		// TODO Auto-generated method stub
		
		entityManager.getTransaction().begin();

//		drink.getOrders().add(orders);
//		entityManager.merge(drink);
		
		orders.getDrinks().add(product);
		entityManager.merge(orders);
		
		entityManager.getTransaction().commit();
		
	}

	public Orders findOrderWithDrinks(LocalDate date) {
		entityManager.getTransaction().begin();
		Orders orders = null;
		
		try{
		  orders = (Orders) entityManager
				.createQuery("select o from Orders o left join fetch o.drinks       where o.date =:value")
				.setParameter("value", date)
				.getSingleResult();
		
		}catch (NoResultException e) {
			System.out.println(e.getMessage());
		}catch (NonUniqueResultException e) {
			System.out.println(e.getMessage());
		}
		entityManager.getTransaction().commit();
		
		
		return orders;
	}
	
	

	
	
	
}