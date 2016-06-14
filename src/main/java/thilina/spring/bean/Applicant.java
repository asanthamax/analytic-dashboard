package thilina.spring.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Applicant {

	@Id
	private String Id;
	
	private String firstName;
	private String lastName;
	private String contactNo;
	private String address;
	private String loyalityPoints;
	private String userName;
	private String email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	
	public Applicant()
	{
		
	}
	public Applicant(Applicant customer)
	{
		super();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.address = customer.getAddress();
		this.Id = customer.getId();
		this.loyalityPoints = customer.getLoyalityPoints();
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoyalityPoints() {
		return loyalityPoints;
	}
	public void setLoyalityPoints(String loyalityPoints) {
		this.loyalityPoints = loyalityPoints;
	}
	@Override
	public String toString() {
		
		StringBuilder builder =new StringBuilder();
		builder.append("Customer Id :").append(this.getId()).append("\n");
		builder.append("Customer First Name :").append(this.getFirstName()).append("\n");
		builder.append("Customer Last Name :").append(this.getLastName()).append("\n");
		builder.append("Customer Contact No :").append(this.getContactNo()).append("\n");
		builder.append("Customer Address :").append(this.getAddress()).append("\n");
		builder.append("Customer Loyality Points:").append(this.getLoyalityPoints()).append("\n");
		builder.append("Customer User Name :").append(this.getUserName()).append("\n");
		builder.append("Customer Password :").append(this.getPassword()).append("\n");
		return builder.toString();
	}
	
}
