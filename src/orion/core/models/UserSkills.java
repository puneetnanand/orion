package orion.core.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "userskills")
public class UserSkills implements Serializable
{
	@EmbeddedId
	protected UserSkillCompKey userSkill;
	@Column(name = "experience", nullable = false, length=20)
	public int experience;
	
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	

	public UserSkillCompKey getUserSkill() {
		return userSkill;
	}

	public void setUserSkill(UserSkillCompKey userSkill) {
		this.userSkill = userSkill;
	}
}
