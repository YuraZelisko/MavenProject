package ua.com.antivirus.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//
//@NamedQueries({
//	@NamedQuery(name="User.findAll", query="select u from User u"),
//	@NamedQuery(name="User.findByUsername", query="select u from User u where u.username like :username")
//})

//@Entity
@Entity
public class User {

@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String username;
private String password;
private String email;
private String phoneNumb;


public User() {
	// TODO Auto-generated constructor stub
}

public User(String username, String password, String email, String phoneNumb) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.phoneNumb = phoneNumb;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumb() {
	return phoneNumb;
}

public void setPhoneNumb(String phoneNumb) {
	this.phoneNumb = phoneNumb;
}

@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", phoneNumb="
			+ phoneNumb + "]";
}





//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
//	private String username;
//	private String email;
//	private String password;
//	private String phone;	
//	
//	@ManyToMany
//	@JoinTable(name="user_book",
//	joinColumns=@JoinColumn(name="user_id"),
//	inverseJoinColumns=@JoinColumn(name="book_id"))
//	private List<Book> books;
//	
//	public User() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public User(String username, String email, String password, String phone) {
//		super();
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.phone = phone;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public List<Book> getBooks() {
//		return books;
//	}
//
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", phone="
//				+ phone + "]";
//	}
	
	
	
	
	
}

