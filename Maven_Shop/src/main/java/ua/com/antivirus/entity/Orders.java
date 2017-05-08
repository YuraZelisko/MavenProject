package ua.com.antivirus.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;

	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "orders_drink", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "drink_id"))
	private List<Product> drinks = new ArrayList<Product>();

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(LocalDate date) {
		super();
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Product> drinks) {
		this.drinks = drinks;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", date=" + date + ", drinks=" + drinks + "]";
	}

}
