package main.java.com.ui.mpb;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import main.java.com.db.pojo.Leads;

@ManagedBean(name="displayLeads", eager=true)
@SessionScoped
public class DisplayLeads {
	private Leads lead;

	/**
	 * @return the id
	 */
	public Leads getLead() {
		return lead;
	}

	/**
	 * @param id the id to set
	 */
	public void setLead(Leads lead) {
		this.lead = lead;
	}

}
