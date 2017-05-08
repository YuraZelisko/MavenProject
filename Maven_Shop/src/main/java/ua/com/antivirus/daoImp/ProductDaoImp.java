package ua.com.antivirus.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import ua.com.antivirus.entity.Orders;
import ua.com.antivirus.entity.User;

public class ProductDaoImp {
	
	private final EntityManager entityManager;

	public  ProductDaoImp(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void save(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

	}

	public List<User> findAll() {

		entityManager.getTransaction().begin();
		List<User> users = entityManager.createQuery("from User").getResultList();
		entityManager.getTransaction().commit();
		return users;
	}

	public User findOne(String name) {

		entityManager.getTransaction().begin();

		User user = null;

		try {
			user = (User) entityManager
					.createQuery("select u from User u where u.name =:value ")
					.setParameter("value", name)
					.getSingleResult();

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		} catch (NonUniqueResultException e) {
			System.out.println(e.getMessage());
		}

		entityManager.getTransaction().commit();

		return user;
	}

	public void delete(String name, String email) {

		entityManager.getTransaction().begin();

		User user = null;

		try {
			user = (User) entityManager.createQuery("select u from User u where u.name =:value1 and u.email =:value2  ")
					.setParameter("value1", name).setParameter("value2", email).getSingleResult();
			
			List<Orders> orders = user.getOrders();

			for (Orders o : orders) {
				o.setUser(null);
				entityManager.merge(o);
				
			}

			entityManager.remove(user);

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		} catch (NonUniqueResultException e) {
			System.out.println(e.getMessage());
		}

		entityManager.getTransaction().commit();
	}

	public void update(User user) {
		entityManager.getTransaction().begin();
		
		entityManager.merge(user);
		
		entityManager.getTransaction().commit();

	}

	public void addOrderToUser(User user, Orders orders) {
		entityManager.getTransaction().begin();
		orders.setUser(user);
		
		entityManager.getTransaction().commit();
		
	}
	

}
