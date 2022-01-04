package cz.vsb.vea.cz.vsb.vea.lab02v2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Manufacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    public Worker worker;

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product product;

    @JsonBackReference
    @Transient
    public long workerId;
    @Transient
    @JsonBackReference
    public long productId;

    public Manufacture() {
    }

    public Manufacture(Worker worker, Product product) {
        this.product=product;
        this.worker=worker;
        this.workerId = worker.getId();
        this.productId = product.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


}