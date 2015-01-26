package main.java.test.com.db.pojo;
import java.util.List;
import java.util.Iterator;

import main.java.com.db.pojo.Credentials;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;

public class TestCredentials {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		try
		{
			Configuration configuration = new Configuration();
		    configuration.configure().addAnnotatedClass(Credentials.class);
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    factory = configuration.buildSessionFactory(serviceRegistry);
			/*factory=new Configuration().configure().addAnnotatedClass(Credentials.class).buildSessionFactory();*/
		}
		catch(Throwable ex)
		{
			System.err.println("Failed to create session factory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		TestCredentials tc=new TestCredentials();
		//tc.addCredentials("shishir","rihsshi_12111984","leader_all");
		tc.listCredentials();
		
		
	}
	public void addCredentials(String name, String password, String managerName)
	{
		Session session=factory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			Credentials credentials=new Credentials();
			credentials.setUsername(name);
			credentials.setPassword(password.getBytes());
			credentials.setManagerName(managerName);
			session.save(credentials);
			tx.commit();
		}
		catch(HibernateException ex)
		{
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
			
		}
	}
	public void listCredentials()
	{
		Session session=factory.openSession();
		Transaction tx=null;
		try
		{
			tx=session.beginTransaction();
			List creds=session.createQuery("from Credentials").list();
			for(Iterator itr=creds.iterator();itr.hasNext();)
			{
				Credentials cred=(Credentials) itr.next();
				if(cred!=null)
				{
					System.out.println("name = " + cred.getUsername());
					System.out.println("password = " + new String(cred.getPassword()));
					System.out.println("manager name = " + cred.getManagerName());					
				}				
			}
			tx.commit();
		}
		catch (HibernateException ex)
		{
			if(tx!=null) tx.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

}
