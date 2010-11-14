package orion.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@Column(name = "username", nullable = false, length=20)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "firstname", nullable = false, length=20)
	private String firstname;
	
	@Column(name = "lastname", nullable = false, length=20)
	private String lastname;
	
	@Column(name = "email", nullable = false, length=30)
	private String email;

	
	
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Profile() {		
	}
	
}