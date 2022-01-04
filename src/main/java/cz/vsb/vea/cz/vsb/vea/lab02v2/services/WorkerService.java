package cz.vsb.vea.cz.vsb.vea.lab02v2.services;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Product;
import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Worker;
import cz.vsb.vea.cz.vsb.vea.lab02v2.repositories.ProductRepository;
import cz.vsb.vea.cz.vsb.vea.lab02v2.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository repo;

    public List<Worker> listAll(){
        return repo.findAll();
    }
    public void save(Worker worker){
        repo.save(worker);
    }
    public Worker get(Long id){
        return  repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
