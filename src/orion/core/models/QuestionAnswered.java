package orion.core.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="questionanswered")
public class QuestionAnswered
{
	@EmbeddedId
	private QAnsweredCompKey QAnsweredCompKey;
	
	@Column(name="date",nullable=false)
	private String date;

	public QAnsweredCompKey getQAnsweredCompKey() {
		return QAnsweredCompKey;
	}

	public void setQAnsweredCompKey(QAnsweredCompKey qAnsweredCompKey) {
		QAnsweredCompKey = qAnsweredCompKey;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
