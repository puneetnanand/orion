package orion.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.Rating;
import orion.core.models.RatingCompKey;
import orion.dao.RatingDao;



@Repository("RatingDao")
@Transactional(readOnly = true)
public class RatingDaoImpl implements RatingDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	public String ratingInsert(String rating)
	{
		RatingCompKey ratingCompKey=new RatingCompKey();
		ratingCompKey.setQuestionId(1);
		ratingCompKey.setUsergotrating("gauravhardiya");
		ratingCompKey.setUserwhorated("gaurav1018");
		Rating rate=new Rating();
		rate.setRatingCompKey(ratingCompKey);
		rate.setRating(rating);
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(rate);
		tx.commit();
		// TODO Auto-generated method stub
		return null;
	}

}
