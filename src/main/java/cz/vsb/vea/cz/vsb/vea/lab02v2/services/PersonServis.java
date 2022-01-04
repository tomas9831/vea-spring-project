package cz.vsb.vea.cz.vsb.vea.lab02v2.services;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
import cz.vsb.vea.cz.vsb.vea.lab02v2.repositories.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServis {
    @Autowired
    private PersonRepo repo;

    public List<Person> listAll(){
        return repo.findAll();
    }
    public void save(Person person){
        repo.save(person);
    }
    public Person get(Long id){
        return  repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }

}
