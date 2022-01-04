package cz.vsb.vea.cz.vsb.vea.lab02v2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

//@Table(name = "myProduct")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String madein;
    private float price;

//    @JsonIgnore
//	@ManyToOne
//	private Person person;

//    @Column(name = "person_id", insertable = false, updatable = false)
//	private int personId;

    public Product() {
        super();
    }

//    public Product(String name, String brand, String madein, float price, Person person){
//        super();
//        this.name=name;
//        this.brand=brand;
//        this.madein=madein;
//        this.price=price;
//        this.person=person;
//    }
    public Product(String name, String brand, String madein, float price){
        super();
        this.name=name;
        this.brand=brand;
        this.madein=madein;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }

//    public int getPersonId() {
//        return personId;
//    }
//
//    public void setPersonId(int personId) {
//        this.personId = personId;
//    }
}
