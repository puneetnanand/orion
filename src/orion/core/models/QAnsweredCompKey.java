package orion.core.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QAnsweredCompKey implements Serializable
{
	@Column(name="question_id",nullable=false)
	private int questionId;
	
	@Column(name="username",nullable=false)
	private String username;
	
	@Column(name="answer",nullable=false)
	private String answer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
