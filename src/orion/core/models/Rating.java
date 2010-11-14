package orion.core.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {

	@EmbeddedId
	private RatingCompKey ratingCompKey;

	@Column(name = "rating", nullable = false)
	private String rating;

	public RatingCompKey getRatingCompKey() {
		return ratingCompKey;
	}

	public void setRatingCompKey(RatingCompKey ratingCompKey) {
		this.ratingCompKey = ratingCompKey;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
}
