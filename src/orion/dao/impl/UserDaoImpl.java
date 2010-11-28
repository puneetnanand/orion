package orion.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.Registration;
import orion.core.models.User;
import orion.core.models.UserSkill;
import orion.core.models.util.UsersManagementUtil;
import orion.core.search.impl.UserSearchImpl;
import orion.dao.UserDao;
import orion.web.helpers.SpringContextHelper;

public class UserDaoImpl implements UserDao {

	private static SessionFactory sessionFactory = (SessionFactory)SpringContextHelper.getBean("sessionFactory");

	public boolean checkLogin(String username, String password) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction tx = session.beginTransaction();
			User user = (User) session
					.createQuery("from User where username='" + username + "'")
					.uniqueResult();
			tx.commit();
			UsersManagementUtil.registerUserOnline(user.getId());
			return true;
		} catch (NullPointerException nE) {
			nE.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUser(String userName) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		User user = (User)session.createQuery("from User where username='"+userName+"'").uniqueResult();
		tx.commit();
		return user;
	}
	
	public boolean createUser(Registration reg) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		if (doesUserNameExist(reg.getUserName())) {
			// Username already in use
			return false;
		} else {
			try {
				User user = new User();
				user = new User();
				user.setFirstname(reg.getFirstname());
				user.setLastname(reg.getLastname());
				user.setUserName(reg.getUserName());
				user.setPassword(reg.getPassword());
				user.setEmail(reg.getEmail());
				session.save(user);

				String skills[] = reg.getSkills().split(",");
				String exp[] = reg.getExperience().split(",");

				UserSkill userSkill = null;
				int size = skills.length;
				for (int i = 0; i < size; i++) {
					userSkill = new UserSkill();
					userSkill.setUserName(reg.getUserName());
					userSkill.setSkill(skills[i]);
					userSkill.setExperience(Integer.parseInt(exp[i]));
					session.save(userSkill);
				}
				tx.commit();
				UserSearchImpl.index(user, skills, exp);
				
				return true;
			} catch (NumberFormatException e) {
				tx.rollback();
				e.printStackTrace();
				return false;
			} catch (HibernateException e) {
				tx.rollback();
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean doesUserNameExist(String userName) {
		System.out.println("Checking if user is already present.\n\n");
		User user = (User) sessionFactory.getCurrentSession()
				.createQuery("from User where username='" + userName + "'")
				.uniqueResult();
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}
}
