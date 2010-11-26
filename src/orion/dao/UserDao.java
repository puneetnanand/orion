package orion.dao;

import orion.core.models.Registration;

public interface UserDao {
	public boolean checkLogin(String username,String password);
	public boolean createUser(Registration reg);
}
