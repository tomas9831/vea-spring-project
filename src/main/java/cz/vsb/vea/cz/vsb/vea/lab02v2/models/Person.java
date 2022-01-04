package cz.vsb.vea.cz.vsb.vea.lab02v2.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Table(name = "myPerson")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "nesmi byt prazdne")
	private String firstName;

	@NotEmpty
	private String lastName;

	private LocalDate dayOfBirth;

//	@OneToMany(mappedBy = "person")
//	private List<Product> products;

	public Person() {
		System.out.println("person constroctor");
	}

	public Person(Long id, String firstName, String lastName, LocalDate dayOfBirth) {
		System.out.println("person constroctor with parameters");
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
	}
	public Person(String firstName, String lastName, LocalDate dayOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
	}

	public int getAge() {
		if(dayOfBirth == null) {
			return 0;
		}
		Period period = Period.between(dayOfBirth, LocalDate.now());
		return period.getYears();
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

	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(LocalDate dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", dayOfBirth=" + dayOfBirth + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	@JsonIgnore
//	public List<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}


}
