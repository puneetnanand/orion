package orion.dao;

import orion.core.models.Registration;
import orion.core.models.User;

public interface UserDao {
	public boolean checkLogin(String username,String password);
	public boolean createUser(Registration reg);
	public User getUser(String userName);
}
