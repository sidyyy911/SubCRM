package main.java.test.com.db.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import static java.lang.System.out;
import org.hibernate.Transaction;
import main.java.com.db.pojo.Leads;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.text.ParseException;

public class TestLeads {

		private static SessionFactory factory;

		public static void main(String[] args) {
			try
			{
				factory=new Configuration().configure().addAnnotatedClass(Leads.class).buildSessionFactory();
			}
			catch(Throwable ex)
			{
				System.err.println("Failed to create session factory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		TestLeads tl=new TestLeads();
		//tl.addLeads();
		tl.listLeads();
	}
		public void addLeads()
		{
			
			Session session=factory.openSession();
			Transaction tx=null;
			try
			{
				tx=session.beginTransaction();
				Leads l=new Leads();
				l.setAddress("G-76, FF, South City II, Gurgaon");
				SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				String callDateStr="20-12-2014";
				Date callDate=sdf1.parse(callDateStr);
				l.setCallDate(callDate);
				l.setCity("Gurgaon");
				l.setCustomerEmail("sidyyy911@gmail.com");
				l.setCustomerName("Siddharth");
				
				SimpleDateFormat sdf2=new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH);
				String demoDateStr="21-12-2014 12:00";
				Date demoDate=sdf2.parse(demoDateStr);
				
				
				l.setDemoDate(demoDate);
				l.setLeadStatus("Open");
				l.setLeadType("SMS");
				l.setManager("Varun Jain");
				l.setMobile("7838026600");
				l.setSource("Newspaper Ad");
				l.setState("Haryana");
				l.setZonalManager("Shishir");
				session.save(l);
				tx.commit();
			}			
			catch(HibernateException ex)
			{
				if(tx!=null) tx.rollback();
				ex.printStackTrace();			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				session.close();
			}
		}
		public void listLeads()
		{
			Session session=factory.openSession();
			Transaction tx=null;
			try
			{
				tx=session.beginTransaction();
				String hql="from Leads";
				Query q=session.createQuery(hql);
				List results=q.list();
				if(null!=results && !results.isEmpty() && results.size()>0)
				{
					for(Iterator resultsItr=results.iterator(); resultsItr.hasNext();)
					{
						Leads lead=(Leads) resultsItr.next();
						if(null!=lead)
						{
							out.println("");
							out.println("************************************Record Starts********************************************");
							System.out.println("Id = " + lead.getId());
							System.out.println("State = " + lead.getState());
							System.out.println("City = " + lead.getCity());
							System.out.println("Lead Type = " + lead.getLeadType());
							System.out.println("Call Date = " + lead.getCallDate());
							System.out.println("Zonal Manager = " + lead.getZonalManager());
							System.out.println("Manager = " + lead.getManager());
							System.out.println("Source = " + lead.getSource());
							System.out.println("Customer Name = " + lead.getCustomerName());
							out.println("Address = " + lead.getAddress());
							out.println("Mobile = " + lead.getMobile());
							out.println("Alternate Number = " + lead.getAlternateNumber());
							out.println("Customer Email = " + lead.getCustomerEmail());
							out.println("Demo Date = " + lead.getDemoDate());
							out.println("Feedback = " + lead.getFeedback());
							out.println("Lead Status = " + lead.getLeadStatus());
							out.println("Demo Given = " + lead.getDemoGiven());
							out.println("Reschedule Date = " + lead.getRescheduleDate());
							out.println("Reject Reason = " + lead.getRejectReason());
							out.println("Other Model Purchased = " + lead.getOtherModelPurchased());
							out.println("Livpure Model Purchased = " + lead.getLivpureModelPurchased());
							out.println("Remarks = " + lead.getRemarks());
							out.println("*************************************Record Ends*********************************************");												
						}							
					}
				}
				tx.commit();
			}
			catch(HibernateException ex)
			{
				if(null!=tx)
					tx.rollback();
				ex.printStackTrace();
			}
			finally
			{
				session.close();				
			}
		}
}
