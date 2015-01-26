package main.java.com.ui.mpb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import main.java.com.db.helper.CredentialsHelper;
import main.java.com.db.helper.LeadsHelper;

@ManagedBean(name="profile", eager=true)
@SessionScoped
public class Profile 
{
	@ManagedProperty(value="#{login.managerName}")
	private String managerName;
	private List leads;
	private Integer countOpen;
	private Integer countClosed;
	private Integer countAll;

	/**
	 * @return the leads
	 */
	public List getLeads() {
		return leads;
	}

	/**
	 * @param leads the leads to set
	 */
	public void setLeads(List leads) {
		this.leads = leads;
	}

	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public String getAllLeads()
	{
		leads=LeadsHelper.getAllLeads(managerName);
		return "displayLeads";
	}
	public String getOpenLeads()
	{
		leads=LeadsHelper.getOpenLeads(managerName);
		return "displayLeads";		
	}
	
	/**
	 * @return the countOpen
	 */
	public Integer getCountOpen() {
		return countOpen;
	}

	/**
	 * @param countOpen the countOpen to set
	 */
	public void setCountOpen(Integer countOpen) {
		this.countOpen = countOpen;
	}

	/**
	 * @return the countClosed
	 */
	public Integer getCountClosed() {
		return countClosed;
	}

	/**
	 * @param countClosed the countClosed to set
	 */
	public void setCountClosed(Integer countClosed) {
		this.countClosed = countClosed;
	}

	/**
	 * @return the countAll
	 */
	public Integer getCountAll() {
		return countAll;
	}

	/**
	 * @param countAll the countAll to set
	 */
	public void setCountAll(Integer countAll) {
		this.countAll = countAll;
	}

	@PostConstruct
	public void init()
	{
		String managerType=CredentialsHelper.getManagerType(managerName);
		LeadsHelper.getCounts(managerName, managerType, countOpen, countClosed, countAll);
		
		
		
	}
}


