package cz.vsb.vea.cz.vsb.vea.lab02v2.services;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Product;
import cz.vsb.vea.cz.vsb.vea.lab02v2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(){
        return repo.findAll();
    }
    public void save(Product product){
        repo.save(product);
    }
    public Product get(Long id){
        return  repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
