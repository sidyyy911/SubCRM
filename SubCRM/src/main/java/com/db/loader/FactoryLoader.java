package main.java.com.db.loader;

import main.java.com.db.pojo.Credentials;
import main.java.com.db.pojo.Leads;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class FactoryLoader {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	private static Configuration configuration;
	static
	{
		try
		{
			configuration = new Configuration();		
			configuration.configure().addAnnotatedClass(Credentials.class);
			configuration.configure().addAnnotatedClass(Leads.class);
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			factory = configuration.buildSessionFactory(serviceRegistry);
		}
		catch(Throwable ex)
		{
			System.err.println("Failed to create session factory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	private FactoryLoader() {}
	/**
	 * @return the factory
	 */
	public static SessionFactory getFactory() {
		return factory;
	}
	
}
