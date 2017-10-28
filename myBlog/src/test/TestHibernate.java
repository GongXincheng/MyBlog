package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestHibernate {

	@Test
	public void createUserTable(){
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
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
		sessionFactory.close();
		
	}
	
}
