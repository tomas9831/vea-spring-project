package cz.vsb.vea.cz.vsb.vea.lab02v2.controllers;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Person;
import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Product;
import cz.vsb.vea.cz.vsb.vea.lab02v2.services.PersonServis;
import cz.vsb.vea.cz.vsb.vea.lab02v2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonServis service;

    @RequestMapping("/person")
    public String viewHomePage(Model model){
        List<Person> listPersons = service.listAll();
        model.addAttribute("listPersons",listPersons);

        return "index_person";
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/person/new")
    public String showNewPersonForm(Model model){
        Person person = new Person();
        model.addAttribute("person",person);

        return "new_person";
    }
    @RequestMapping(value = "/person/save", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person) {
        service.save(person);

        return "redirect:/person";
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/person/edit/{id}")
    public ModelAndView showEditPersonPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_person");
        Person person = service.get(id);
        mav.addObject("person", person);

        return mav;
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/person";
    }
}
