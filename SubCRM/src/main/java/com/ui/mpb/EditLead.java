package main.java.com.ui.mpb;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import main.java.com.db.helper.LeadsHelper;
import main.java.com.db.pojo.Leads;

@ManagedBean(name="editLead", eager=true)
@ViewScoped
public class EditLead {
	@ManagedProperty(value="#{displayLeads.lead}")
	private Leads leadFromDL;
	
	private Leads lead;
	
	@PostConstruct
	public void init()
	{
		lead=new Leads(); 
		LeadsHelper.mapLeads(leadFromDL, lead);
	}
	/**
	 * @return the leadFromDL
	 */
	public Leads getLeadFromDL() {
		return leadFromDL;
	}

	/**
	 * @param leadFromDL the leadFromDL to set
	 */
	public void setLeadFromDL(Leads leadFromDL) {
		this.leadFromDL = leadFromDL;
	}

	

	/**
	 * @return the lead
	 */
	public Leads getLead() {
		return lead;
	}

	/**
	 * @param lead the lead to set
	 */
	public void setLead(Leads lead) {
		this.lead = lead;
	}
	
	public void onFeedbackChange(ValueChangeEvent e)
	{
		String value=e.getNewValue().toString();
		
		if(value.equalsIgnoreCase("Sold") || value.equalsIgnoreCase("Not Interested"))
		{
			lead.setLeadStatus("Closed");
		}
		else if(value.equalsIgnoreCase("Followup Required") || value.equals(" "))
		{
			lead.setLeadStatus("Open");
		}
	}

}
