package orion.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class MyProfileDaoImpl implements MyProfileDao
{
	@Autowired
	  private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public ArrayList getProfile(String username)
	{
		Transaction tx=null;
		Session session=sessionFactory.getCurrentSession();
		tx = session.beginTransaction();
		List lst = session.createQuery("select p.email,count(q.username),count(qa.username)," +
				"r.rating from profile p,questionasked q,questionanswered qa,rating r " +
				"where p.username=q.username and p.username=qa.username and p.username=")
        .list();
		// TODO Auto-generated method stub
		return null;
	}

}
