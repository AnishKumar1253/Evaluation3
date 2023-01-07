package com.masai.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
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
			message = "{password.invalid")
	private String password;
	
	/**A user can file multiple fir's but an fir will be filed by a particular user only **/
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	private List<FIR> firs=new ArrayList<>();
	
	public User() {}

	public User(int id, @Pattern(regexp = "^[a-zA-Z]+$", message = "{firstname.invalid}") String firstname,
			@Pattern(regexp = "^[a-zA-Z]+$", message = "{lastname.invalid}") String lastname,
			@Size(min = 10, max = 10, message = "{mobileNumber.invalid}") String mobileNumber, String address,
			@Min(value = 8, message = "{age.invalid}") Integer age, String gender,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$", message = "{password.invalid") String password,
			List<FIR> firs) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.firs = firs;
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

	public List<FIR> getFirs() {
		return firs;
	}

	public void setFirs(List<FIR> firs) {
		this.firs = firs;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", age=" + age + ", gender=" + gender + ", password="
				+ password + ", firs=" + firs + "]";
	}
	
	
}
