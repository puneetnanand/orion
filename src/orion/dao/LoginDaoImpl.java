package orion.dao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.OnlineUser;



@Repository("LoginDao")
@Transactional(readOnly = true)
public class LoginDaoImpl implements LoginDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public ArrayList checkLogin(String username,String password)
	{
		final String dateFormate = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
	    String date=sdf.format(cal.getTime()).toString();
	    
		ArrayList arraylist=new ArrayList();
		List list=sessionFactory.getCurrentSession().createQuery("from Profile where username='"+username+"'").list();
		Iterator iter=list.listIterator();

		if(iter.hasNext())
		{
			List lit=sessionFactory.getCurrentSession().createQuery("from OnlineUser where username='"+username+"'").list();
			Iterator itr=lit.listIterator();
			if(!itr.hasNext())
			{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			OnlineUser user=new OnlineUser();
			user.setUsername(username);
			user.setStatus("online");
			session.save(user);
			tx.commit();
			}
			arraylist.add(0,"present");
			arraylist.add(1,sessionFactory.getCurrentSession().createQuery("from OnlineUser where status='online'").list());
			return arraylist;
		}
		return arraylist;
	}
	
}
