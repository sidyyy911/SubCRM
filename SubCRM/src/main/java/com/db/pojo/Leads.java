package main.java.com.db.pojo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LEADS")
public class Leads {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="leadtype")
	private String leadType;
	
	@Column(name="call_date")
	@Temporal(TemporalType.DATE)
	private Date callDate;
	
	@Column(name="zonal_manager")
	private String zonalManager;
	
	@Column(name="regional_manager")
	private String regionalManager;
	
	@Column(name="manager")
	private String manager;
	
	@Column(name="executive")
	private String executive;
	
	@Column(name="source")
	private String source;
	
	@Column(name="cname")
	private String customerName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="alt_no")
	private String alternateNumber;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="demo_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date demoDate;
	
	@Column(name="feedback")
	private String feedback;
	
	@Column(name="lead_status")
	private String leadStatus;
	
	@Column(name="demo_given")
	private String demoGiven;
	
	@Column(name="reschedule_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date rescheduleDate;
	
	@Column(name="reject_reason")
	private String rejectReason;
	
	
	@Column(name="other_model_purchased")
	private String otherModelPurchased;
	
	@Column(name="livpure_model_purchased")
	private String livpureModelPurchased;
	
	@Column(name="remarks")
	private String remarks;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the leadType
	 */
	public String getLeadType() {
		return leadType;
	}

	/**
	 * @param leadType the leadType to set
	 */
	public void setLeadType(String leadType) {
		this.leadType = leadType;
	}

	/**
	 * @return the callDate
	 */
	public Date getCallDate() {
		return callDate;
	}

	/**
	 * @param callDate the callDate to set
	 */
	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	/**
	 * @return the zonalManager
	 */
	public String getZonalManager() {
		return zonalManager;
	}

	/**
	 * @param zonalManager the zonalManager to set
	 */
	public void setZonalManager(String zonalManager) {
		this.zonalManager = zonalManager;
	}

	/**
	 * @return the regionalManager
	 */
	public String getRegionalManager() {
		return regionalManager;
	}

	/**
	 * @param regionalManager the regionalManager to set
	 */
	public void setRegionalManager(String regionalManager) {
		this.regionalManager = regionalManager;
	}

	/**
	 * @return the executive
	 */
	public String getExecutive() {
		return executive;
	}

	/**
	 * @param executive the executive to set
	 */
	public void setExecutive(String executive) {
		this.executive = executive;
	}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the alternateNumber
	 */
	public String getAlternateNumber() {
		return alternateNumber;
	}

	/**
	 * @param alternateNumber the alternateNumber to set
	 */
	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	/**
	 * @return the customerEmail
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * @param customerEmail the customerEmail to set
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * @return the demoDate
	 */
	public Date getDemoDate() {
		return demoDate;
	}

	/**
	 * @param demoDate the demoDate to set
	 */
	public void setDemoDate(Date demoDate) {
		this.demoDate = demoDate;
	}

	/**
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * @param feedback the feedback to set
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	/**
	 * @return the leadStatus
	 */
	public String getLeadStatus() {
		return leadStatus;
	}

	/**
	 * @param leadStatus the leadStatus to set
	 */
	public void setLeadStatus(String leadStatus) {
		this.leadStatus = leadStatus;
	}

	/**
	 * @return the demoGiven
	 */
	public String getDemoGiven() {
		return demoGiven;
	}

	/**
	 * @param demoGiven the demoGiven to set
	 */
	public void setDemoGiven(String demoGiven) {
		this.demoGiven = demoGiven;
	}

	/**
	 * @return the rescheduleDate
	 */
	public Date getRescheduleDate() {
		return rescheduleDate;
	}

	/**
	 * @param rescheduleDate the rescheduleDate to set
	 */
	public void setRescheduleDate(Date rescheduleDate) {
		this.rescheduleDate = rescheduleDate;
	}

	/**
	 * @return the rejectReason
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * @param rejectReason the rejectReason to set
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	/**
	 * @return the otherModelPurchased
	 */
	public String getOtherModelPurchased() {
		return otherModelPurchased;
	}

	/**
	 * @param otherModelPurchased the otherModelPurchased to set
	 */
	public void setOtherModelPurchased(String otherModelPurchased) {
		this.otherModelPurchased = otherModelPurchased;
	}

	/**
	 * @return the livpureModelPurchased
	 */
	public String getLivpureModelPurchased() {
		return livpureModelPurchased;
	}

	/**
	 * @param livpureModelPurchased the livpureModelPurchased to set
	 */
	public void setLivpureModelPurchased(String livpureModelPurchased) {
		this.livpureModelPurchased = livpureModelPurchased;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
