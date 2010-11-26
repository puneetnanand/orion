package orion.dao.impl;

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
import orion.dao.UserDao;

@Repository("UserDao")
@Transactional(readOnly = false)
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean checkLogin(String username, String password) {
		try {
			User user = (User) sessionFactory.getCurrentSession()
					.createQuery("from User where username='" + username + "'")
					.uniqueResult();
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

	public boolean createUser(Registration reg) {
		if (doesUserNameExist(reg.getUserName())) {
			// Username already in use
			return false;
		} else {
			try {
				User user = new User();
				Session session = sessionFactory.getCurrentSession();
				user = new User();
				user.setFirstname(reg.getFirstname());
				user.setLastname(reg.getLastname());
				user.setUserName(reg.getUserName());
				user.setPassword(reg.getPassword());
				user.setEmail(reg.getEmail());
				session.save(user);

				String skill[] = reg.getSkills().split(",");
				String exp[] = reg.getExperience().split(",");

				UserSkill userSkill = null;
				int size = skill.length;
				for (int i = 0; i < size; i++) {
					userSkill = new UserSkill();
					userSkill.setUserName(reg.getUserName());
					userSkill.setSkill(skill[i]);
					userSkill.setExperience(Integer.parseInt(exp[i]));
					session.save(userSkill);
				}

				return true;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return false;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	public boolean doesUserNameExist(String userName) {
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
