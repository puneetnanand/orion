package orion.core.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserSkillCompKey implements Serializable
{

	@Column(name = "username", nullable = false, length=20)
	private String userName;
	@Column(name = "skills", nullable = false)
	private String skills;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSkill() {
		return skills;
	}

	public void setSkill(String skills) {
		this.skills = skills;
	}

	
	}

