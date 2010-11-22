package orion.logic.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.Registration;
import orion.dao.ProfileDao;
import orion.logic.ProfileService;





@Service("profileService")
@Transactional(readOnly = true)
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	ProfileDao profileDao;
	
	@Override
	public String insertProfile(Registration reg) {
		// TODO Auto-generated method stub
		return profileDao.createProfile(reg);
	}

}
