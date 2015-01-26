package main.java.com.db.helper;

import java.util.List;

import main.java.com.db.loader.FactoryLoader;
import main.java.com.db.pojo.Leads;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class LeadsHelper {
	private static SessionFactory factory;
	private static String actualManagerName=null;
	private static String criteriaCondition="";
	static
	{
		factory=FactoryLoader.getFactory();
	}
	@SuppressWarnings("rawtypes")
	public static List getAllLeads(String managerName)
	{
		Session session=factory.openSession();
		Transaction tx = null;
		List results = null;
		try
		{
			tx=session.beginTransaction();
			String hql=" from Leads l where lower(trim(l.manager)) = lower(trim(:manName))";
			Query query=session.createQuery(hql);
			query.setParameter("manName", managerName);
			results=query.list();			
		}
		catch(HibernateException he)
		{
			if(tx!=null) tx.rollback();
			he.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return results;
	}
	
	@SuppressWarnings("rawtypes")
	public static List getOpenLeads(String managerName)
	{
		Session session=factory.openSession();
		Transaction tx = null;
		List results = null;
		try
		{
			tx=session.beginTransaction();
			String hql=" from Leads l where " + criteriaCondition + "and (lower(trim(l.leadStatus))='open' or  l.leadStatus is null)";
			Query query=session.createQuery(hql);
			query.setParameter("manName", managerName);
			results=query.list();			
		}
		catch(HibernateException he)
		{
			if(tx!=null) tx.rollback();
			he.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return results;
	}
	
	@SuppressWarnings("rawtypes")
	public static List getClosedLeads(String managerName)
	{
		Session session=factory.openSession();
		Transaction tx = null;
		List results = null;
		try
		{
			tx=session.beginTransaction();
			String hql=" from Leads l where lower(trim(l.manager)) = lower(trim(:manName)) and lower(trim(l.leadStatus))='closed'";
			Query query=session.createQuery(hql);
			query.setParameter("manName", managerName);
			results=query.list();			
		}
		catch(HibernateException he)
		{
			if(tx!=null) tx.rollback();
			he.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return results;
	}
	
	public static void mapLeads(Leads source, Leads dest)
	{
		dest.setAddress(source.getAddress());
		dest.setAlternateNumber(source.getAlternateNumber());
		dest.setCallDate(source.getCallDate());
		dest.setCity(source.getCity());
		dest.setCustomerEmail(source.getCustomerEmail());
		dest.setCustomerName(source.getCustomerName());
		dest.setDemoDate(source.getDemoDate());
		dest.setDemoGiven(source.getDemoGiven());
		dest.setExecutive(source.getExecutive());
		dest.setFeedback(source.getFeedback());
		dest.setId(source.getId());
		dest.setLeadStatus(source.getLeadStatus());
		dest.setLeadType(source.getLeadType());
		dest.setLivpureModelPurchased(source.getLivpureModelPurchased());
		dest.setManager(source.getManager());
		dest.setMobile(source.getMobile());
		dest.setOtherModelPurchased(source.getOtherModelPurchased());
		dest.setRegionalManager(source.getRegionalManager());
		dest.setRejectReason(source.getRejectReason());
		dest.setRemarks(source.getRemarks());
		dest.setRescheduleDate(source.getRescheduleDate());
		dest.setSource(source.getSource());
		dest.setState(source.getState());
		dest.setZonalManager(source.getZonalManager());
	}
	private static void setActualMngNameAndCriteria(String managerName, String managerType)
	{
		if(managerType.equals("Z"))
		{
		actualManagerName=managerName.trim().substring(6);
		criteriaCondition="lower(trim(l.zonalManager))=lower(:manName) ";
		}
	if(managerType.equals("R"))
	{
		actualManagerName=managerName.trim().substring(6);
		criteriaCondition="lower(trim(l.regionalManager))=lower(:manName) ";
	}
	if(managerType.equals("M"))
		{
		actualManagerName=managerName.trim().substring(5);
		criteriaCondition="lower(trim(l.manager))=lower(:manName) ";
		}
	if(managerType.equals("E"))
		{
		actualManagerName=managerName.trim();
		criteriaCondition="lower(trim(l.executive))=lower(:manName) ";
		}
	}
	
	public static void getCounts(String managerName, String managerType, Integer countOpen, Integer countClosed, Integer countAll)
	{
		Session session=factory.openSession();
		Transaction tx = null;
		//List results = null;
		try
		{
			tx=session.beginTransaction();			
			setActualMngNameAndCriteria(managerName, managerType);
			String hqlOpen="select count(1) from leads l where " + criteriaCondition + "and (lower(trim(l.leadStatus))='open' or l.leadStatus is null)";
			String hqlClosed="select count(1) from leads l where " + criteriaCondition + "and lower(trim(l.leadStatus))='closed'";
			String hqlAll="select count(1) from leads l where " + criteriaCondition;
			Query openQuery=session.createQuery(hqlOpen);
			Query closedQuery=session.createQuery(hqlClosed);
			Query allQuery=session.createQuery(hqlAll);
			openQuery.setParameter("manName", actualManagerName);
			closedQuery.setParameter("manName", actualManagerName);
			allQuery.setParameter("manName", actualManagerName);
			countOpen=openQuery.getFirstResult();
			countClosed=closedQuery.getFirstResult();
			countAll=allQuery.getFirstResult();			
		}
		catch(HibernateException he)
		{
			if(tx!=null) tx.rollback();
			he.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

}
