package main.java.com.db.pojo;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;


import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name="CREDENTIALS")
public class Credentials {
	@Column(name="username")
	@Id
	private String username;
	
	@Column(name="password_", columnDefinition="TINYBLOB NOT NULL")
	@ColumnTransformer(read="AES_DECRYPT(password_,'ssasn')",
	write="AES_ENCRYPT(?,'ssasn')")
	private byte[] password;
	
	@Column(name="manager_name")
	private String managerName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	

}
