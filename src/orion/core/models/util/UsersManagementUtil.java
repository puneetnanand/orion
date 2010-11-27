package orion.core.models.util;

import java.util.HashSet;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.User;
import orion.dao.UserDao;
import orion.dao.impl.UserDaoImpl;

public class UsersManagementUtil {
	
	private static HashSet<Long> set = new HashSet<Long>();    
		
	public static boolean registerUserOnline (long userId) {
		return set.add(userId);
	}

	public boolean registerUserOnline (String userName) {
		try {
			UserDao userDao = new UserDaoImpl();
			System.out.println("userName - "+userName);
			User user = (User)userDao.getUser(userName);
			System.out.println("printing email - "+user.getEmail());
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
