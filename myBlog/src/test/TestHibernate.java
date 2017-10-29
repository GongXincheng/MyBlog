package test;

import gxc.utils.HibernateUtil;

import org.hibernate.Session;
import org.junit.Test;

public class TestHibernate {

	@Test
	public void createUserTable(){
		
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		
	/*	
	  	User u = new User();
		u.setUsername("GXC");
		u.setPassword("GXC");
		u.setRole(1);
		u.setRegistDate(new Date());
		
		session.save(u);
	*/
		
		session.getTransaction().commit();
		session.close();
	}
	
}
