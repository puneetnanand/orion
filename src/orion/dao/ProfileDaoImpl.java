package orion.dao;

import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orion.core.models.Profile;
import orion.core.models.Registration;
import orion.core.models.UserSkillCompKey;
import orion.core.models.UserSkills;





@Repository("ProfileDao")
@Transactional(readOnly = true)
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	  private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	public String createProfile(Registration reg) 
	{
		
		List list=sessionFactory.getCurrentSession().createQuery("from Profile where username='"+reg.getUserName()+"'").list();
		Iterator iter=list.listIterator();
		UserSkillCompKey userskill=new UserSkillCompKey();
		UserSkills sk=new UserSkills();
		if(!iter.hasNext())
		{
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Profile profile=new Profile();
			profile.setFirstname(reg.getFirstname());
			profile.setLastname(reg.getLastname());
			profile.setUserName(reg.getUserName());
			profile.setPassword(reg.getPassword());
			profile.setEmail(reg.getEmail());
			session.save(profile);
			tx.commit();
			String skill[]=reg.getSkills().split(",");
			String exp[]=reg.getExperience().split(",");
			int len=skill.length;
			
			for(int i=0;i<len;i++)
			{	Session session1=sessionFactory.openSession();
				Transaction tx1=session1.beginTransaction();
				System.out.println(skill[i]);
				userskill.setUserName(reg.getUserName());
				userskill.setSkill(skill[i]);
				
				sk.setUserSkill(userskill);
				sk.setExperience(Integer.parseInt(exp[i]));
				session1.save(sk);
				tx1.commit();
			}
			
			//sessionFactory.getCurrentSession().persist(profile);
			return "Record inserted";
		}
		else
		{
			return "Username already present";
		}
	
	}

}
