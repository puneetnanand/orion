package orion.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "questionasked")
public class PostQuestion
{
	@Id
	@GeneratedValue
	@Column(name = "question_id")
	private int questionId;
	
	@Column(name="username",nullable=false)
	private String username;

	@Column(name="question",nullable=false)
	private String question;
	
	@Column(name="date",nullable=false)
	private String date;
	
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
	
}
