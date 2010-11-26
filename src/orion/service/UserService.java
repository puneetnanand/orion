package orion.service;

import orion.core.models.Registration;

public interface UserService {
	public boolean createUser(Registration reg);
	public boolean checkLogin(String username,String password);
}