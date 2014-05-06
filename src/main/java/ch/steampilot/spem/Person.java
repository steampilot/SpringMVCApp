package ch.steampilot.spem;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "person")
public class Person {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Basic
private String firstName;

@Basic
private String lastName;

@Basic
private Date birthDate;

@Basic
private String address1;

@Basic
private String address2;

@Basic
private int zipCode;

@Basic
private String city;

@Basic
private String country;

@Basic
private String email;

@OneToMany(cascade = Cascade Type.ALL, fetch = FetchType.LAZY)
@JoinColumn(name="id")
private Set<Venue> venue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Venue getVenue(){
		return venue;
	}
	
	public void setVenue(Venue venue ){this.venue = venue;}
}
