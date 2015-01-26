package main.java.com.db.helper;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import main.java.com.db.loader.FactoryLoader;
import main.java.com.db.pojo.Credentials;
import java.lang.NullPointerException;
import java.lang.IllegalArgumentException;

public class CredentialsHelper {
	private static SessionFactory factory;
	static
	{
		factory=FactoryLoader.getFactory();
	}
	public static String verifyCredentials(String username, String password)
	{
		Session session = factory.openSession();
		Transaction tx=null;
		String retVal=null;
		try
		{
			tx=session.beginTransaction();
			String hql = "from Credentials c where c.username = :user_name";
			Query query = session.createQuery(hql);
			query.setParameter("user_name", username);
			List results = query.list();
			//System.out.println("results size "+results.size());
			if(results.isEmpty() && results.size()==0)
			{
				tx.commit();
				retVal="1";
			}
			if(null==retVal && results.size()==1)
			{
				
				String dbPass=null;
				String manager=null;
				Credentials c = (Credentials) results.get(0);
				if(null!=c && null!=c.getPassword())
				{
				dbPass=new String(c.getPassword());
				}
				if(null!=c && dbPass!=null && password.equals(dbPass))
				{
					manager=c.getManagerName();
					tx.commit();
					retVal = manager;
				}
				else if(null!=c && dbPass!=null && !password.equals(dbPass))
				{
					tx.commit();
					retVal = "2";
				}
			}
			else if (null==retVal)
			{
				retVal="3";
			}
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
		return retVal;
	}
	
	public static String getManagerType(String managerName)
	{
		try
		{
			if(null==managerName)
				{
					throw new NullPointerException("Manager name is Null");
				}
			else if(managerName.equals("")) 
				throw new IllegalArgumentException("Manager name is empty");			
			else if(managerName.trim().toLowerCase().startsWith("zmgr!!"))
				return "Z";
			else if(managerName.trim().toLowerCase().startsWith("rmgr!!"))
				return "R";
			else if(managerName.trim().toLowerCase().startsWith("mgr!!"))
				return "M";
			else return "E";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}	

}
