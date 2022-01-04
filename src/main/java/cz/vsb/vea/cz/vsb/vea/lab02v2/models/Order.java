//package cz.vsb.vea.cz.vsb.vea.lab02v2.models;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name = "myOrder")
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//
//	private double price;
//
////	@JsonIgnore
////	@ManyToOne
////	private Person person;
//
////	@Column(name = "person_id", insertable = false, updatable = false)
////	private int personId;
//
//	public Order() {
//	}
//
////	public Order(double price, Person person) {
////		this.price = price;
////		this.person = person;
////	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
////	public Person getPerson() {
////		return person;
////	}
////
////	public void setPerson(Person person) {
////		this.person = person;
////	}
////
////	public int getPersonId() {
////		return personId;
////	}
////
////	public void setPersonId(int personId) {
////		this.personId = personId;
////	}
//
//}
