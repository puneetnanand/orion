package orion.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.Question;
import orion.dao.PostQuestionDao;


import java.util.Calendar;
import java.text.SimpleDateFormat;

@Repository("PostQuestionDao")
@Transactional(readOnly = true)
public class PostQuestionDaoImpl implements PostQuestionDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public String postQuestion(String username, String question)
	{
		final String dateFormate = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
	    String date=sdf.format(cal.getTime()).toString();
	    Session session=null;
	    try{
	    session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Question postQ=new Question();
		postQ.setUsername(username);
		postQ.setQuestion(question);
		postQ.setDate(date);
		int id=(Integer) session.save(postQ);
		tx.commit();
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	    finally{
	    	session.close();
	    }
		return "Done";
	}

}
