package orion.core.models.util;

import java.util.HashSet;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import orion.core.models.User;

public final class UsersManagementUtil {
	
	@Autowired
	private static SessionFactory sessionFactory;
	private static HashSet<Long> set = new HashSet<Long>();    
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	public static boolean registerUserOnline (long userId) {
		return set.add(userId);
	}
	
	public static boolean registerUserOnline (String userName) {
		try {
			User user = (User)sessionFactory.getCurrentSession().createQuery("from User where username='"+userName+"'").uniqueResult();
			return set.add(user.getId());
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		} catch (NullPointerException nE) {
			nE.printStackTrace();
			return false;
		}
	}
	
	public static boolean removeUserOffline (long userId) {
		return set.remove(userId);
	}
	
	public static boolean checkUserOnline (long userId) {
		return set.contains(userId);
	}
}
