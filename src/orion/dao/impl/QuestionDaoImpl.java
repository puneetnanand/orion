package orion.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.Question;
import orion.dao.QuestionDao;
import orion.web.helpers.SpringContextHelper;

import java.util.Calendar;
import java.text.SimpleDateFormat;

@Repository("QuestionDao")
@Transactional(readOnly = true)
public class QuestionDaoImpl implements QuestionDao {
	
	private static SessionFactory sessionFactory = (SessionFactory)SpringContextHelper.getBean("sessionFactory");

	public boolean createQuestion(String username, String question) {
		final String dateFormate = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormate);
		String date = sdf.format(cal.getTime()).toString();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			Question postQ = new Question();
			postQ.setUsername(username);
			postQ.setQuestion(question);
			postQ.setDate(date);
			int id = (Integer) session.save(postQ);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error while creating question");
			return false;
		}
		return true;
	}

}
