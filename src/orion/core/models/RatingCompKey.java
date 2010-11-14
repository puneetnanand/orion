package orion.core.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RatingCompKey implements Serializable
{
	@Column(name="question_id",nullable=false)
	private int questionId;
	
	@Column(name="userwhorated",nullable=false)
	private String userwhorated;
	
	@Column(name="usergotrating",nullable=false)
	private String usergotrating;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getUserwhorated() {
		return userwhorated;
	}

	public void setUserwhorated(String userwhorated) {
		this.userwhorated = userwhorated;
	}

	public String getUsergotrating() {
		return usergotrating;
	}

	public void setUsergotrating(String usergotrating) {
		this.usergotrating = usergotrating;
	}
}
