package cz.vsb.vea.cz.vsb.vea.lab02v2.services;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Manufacture;
import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Worker;
import cz.vsb.vea.cz.vsb.vea.lab02v2.repositories.ManufactureRepository;
import cz.vsb.vea.cz.vsb.vea.lab02v2.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureService {
    @Autowired
    private ManufactureRepository repo;

    public List<Manufacture> listAll(){
        return repo.findAll();
    }
    public void save(Manufacture worker){
        repo.save(worker);
    }
    public Manufacture get(Long id){
        return  repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
