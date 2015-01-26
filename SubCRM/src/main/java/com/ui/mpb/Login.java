package main.java.com.ui.mpb;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.java.com.db.helper.CredentialsHelper;
@ManagedBean(name="login", eager=true)
@SessionScoped
public class Login {
	private String username;
	private String usernameDisplayed="";
	private String password="";
	private String managerName="";
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the usernameDisplayed
	 */
	public String getUsernameDisplayed() {
		return usernameDisplayed;
	}
	/**
	 * @param usernameDisplayed the usernameDisplayed to set
	 */
	public void setUsernameDisplayed(String usernameDisplayed) {
		this.usernameDisplayed = usernameDisplayed;
		setUsername(usernameDisplayed);
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String validateCredentials()
	{
		FacesContext fc=FacesContext.getCurrentInstance();
		if(username==null || password==null)
		{
			fc.addMessage(null, new FacesMessage("Login Failed"));			
			return "login";
		}
		String verifySuccessCode=CredentialsHelper.verifyCredentials(username,password);
		if("1".equals(verifySuccessCode))
		{
			fc.addMessage(null, new FacesMessage("Username is invalid"));
			setUsernameDisplayed("");
			setPassword("");
			return "login";
		}
		else
		if("2".equals(verifySuccessCode))
		{
			fc.addMessage(null, new FacesMessage("Password is invalid"));
			setUsernameDisplayed("");
			setPassword("");
			return "login";
		}
		else if("3".equals(verifySuccessCode))
		{
			fc.addMessage(null, new FacesMessage("Unknown error"));
			setUsernameDisplayed("");
			setPassword("");
			return "login";
		}
		else if(null!=verifySuccessCode)
		{
			this.setManagerName(verifySuccessCode);
			//fc.addMessage(null, new FacesMessage("Login successful"));
			setUsernameDisplayed("");
			return "profile";
		}
		return "login";
		
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

}
