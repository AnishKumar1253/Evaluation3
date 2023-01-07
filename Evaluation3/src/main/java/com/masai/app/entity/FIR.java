package com.masai.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fir")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FIR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{firstname.invalid}")
	private String firstname;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{lastname.invalid}")
	private String lastname;
	@Size(min = 10,max = 10,message = "{mobileNumber.invalid}")
	private String mobileNumber;
	private String address;
	@Min(value=8,message="{age.invalid}")
	private Integer age;
	private String gender;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$",
			message = "{password.invalid}")
	private String password;
	
	/** which user filed the fir **/
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	public FIR() {}

	public FIR(int id, @Pattern(regexp = "^[a-zA-Z]+$", message = "{firstname.invalid}") String firstname,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "{lastname.invalid}") String lastname,
			@Size(min = 10, max = 10, message = "{mobileNumber.invalid}") String mobileNumber, String address,
			@Min(value = 8, message = "{age.invalid}") Integer age, String gender,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$", message = "{password.invalid}") String password,
			User user) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FIR [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", age=" + age + ", gender=" + gender + ", password="
				+ password + ", user=" + user + "]";
	}
	
	

}
