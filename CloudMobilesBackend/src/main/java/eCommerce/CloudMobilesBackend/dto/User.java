package eCommerce.CloudMobilesBackend.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "user_detail")
public class User 
{
	/*
	 * Private fields for user
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	@NotBlank(message = "Pleasse enter the First name!")
	private String firstName;
	@Column(name = "last_name")
	@NotBlank(message = "Pleasse enter the Last name!")
	private String lastName;
	@NotBlank(message = "Pleasse enter the Address!")
	private String address;
	@NotBlank(message = "Pleasse enter the Email!")
	@Email
	private String email;
	@Column(name = "contact_number")
	@NotEmpty(message = "Please enter the contact number!")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String contactNumber;
	private String role;
	@NotBlank(message = "Pleasse enter the Password!")
	private String password;
	private boolean enabled = true;
	
	/*--------------*/
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	/*--------------*/
 	
	/*
	 * setters and getters for fields
	 * */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/*
	 * toString method
	 * */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}
		
}
