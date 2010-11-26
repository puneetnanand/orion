package orion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.Registration;
import orion.dao.UserDao;
import orion.service.UserService;

@Service("userService")
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public UserServiceImpl() {
	}

	public boolean createUser(Registration reg) {
		return userDao.createUser(reg);
	}

	public boolean checkLogin(String username, String password) {
		return userDao.checkLogin(username, password);
	}

}