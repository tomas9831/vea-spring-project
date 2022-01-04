package cz.vsb.vea.cz.vsb.vea.lab02v2.REST;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
import cz.vsb.vea.cz.vsb.vea.lab02v2.services.PersonServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonRestController {
    @Autowired
    private PersonServis personService;

    @RequestMapping(path = "/api/persons", method = RequestMethod.GET)
    public List<Person> getAll() {
        return personService.listAll();
    }

    @RequestMapping(path = "/api/persons/{id}", method = RequestMethod.GET)
    public Person find(@PathVariable long id) {
        return personService.get(id);
    }

    @RequestMapping(path = "/api/persons", method = RequestMethod.POST)
    public void create(@Validated @RequestBody Person person) {
        personService.save(person);
    }

//    @RequestMapping(path = "/api/persons/{id}", method = RequestMethod.PUT)
//    public void edit(@Validated @RequestBody Person person, @PathVariable long id) {
//        Person found = personService.get(id);
//        if (found != null) {
//            person.setId((int) id);
//            personService.update(person);
//        }
//    }

    @RequestMapping(path = "/api/persons/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        personService.delete(id);
    }
}
