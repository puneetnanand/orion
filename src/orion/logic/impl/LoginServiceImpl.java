package orion.logic.impl;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orion.dao.LoginDao;
import orion.logic.LoginService;



@Service("loginService")
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService
{

	@Autowired
	LoginDao loginDao;
	
	public LoginServiceImpl(){}
	
	@Override
	public ArrayList logincheck(String username, String password) {
		
		return loginDao.checkLogin(username, password);
	}

}
