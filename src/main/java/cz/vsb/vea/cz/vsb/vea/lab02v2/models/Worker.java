package cz.vsb.vea.cz.vsb.vea.lab02v2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
//@Table(name = "workers")
public class Worker extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    @JsonBackReference
    public List<Manufacture> manufactureList;

    public Worker() {
        super();
    }

    public Worker(@NotNull String firstName, @NotNull String lastName, LocalDate dateOfBirth, List<Manufacture> manufactureList) {
        super(firstName, lastName, dateOfBirth);
        this.manufactureList = manufactureList;
    }
    public Worker(Long id, @NotNull String firstName, @NotNull String lastName, LocalDate dateOfBirth, List<Manufacture> manufactureList) {
        super(id, firstName, lastName, dateOfBirth);
        this.manufactureList = manufactureList;
    }

    public List<Manufacture> getManufactureList() {
        return manufactureList;
    }

    public void setManufactureList(List<Manufacture> manufactureList) {
        this.manufactureList = manufactureList;
        for (Manufacture m : manufactureList) {
            m.worker = this;
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}