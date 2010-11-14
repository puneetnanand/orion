package orion.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "username", nullable = false, length=20)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;
	
	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
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


	public Login() {		
	}
	
}