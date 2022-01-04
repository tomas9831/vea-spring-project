package cz.vsb.vea.cz.vsb.vea.lab02v2.controllers;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Manufacture;
import cz.vsb.vea.cz.vsb.vea.lab02v2.services.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManufactureController {
    @Autowired
    private ManufactureService service;
    //private VehicleService vehicleService;

    @RequestMapping("/manufacture")
    public String viewHomePage(Model model) {
        List<Manufacture> listManufacture = service.listAll();
        model.addAttribute("listManufacture", listManufacture);

        return "manufacture/index_manufacture";
    }

    @RequestMapping("/manufacture/new")
    public String showNewManufactureForm(Model model) {
        Manufacture manufacture = new Manufacture();
        model.addAttribute("manufacture", manufacture);

        return "manufacture/new_manufacture";
    }

    @RequestMapping(value = "/manufacture/" +
            "save", method = RequestMethod.POST)
    public String saveManufacture(@ModelAttribute("manufacture") Manufacture manufacture) {
        service.save(manufacture);

        return "redirect:/manufacture";
    }

    @RequestMapping("/manufacture/edit/{id}")
    public ModelAndView showEditManufacturePage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("/manufacture/edit_manufacture");
        Manufacture manufacture = service.get(id);
        mav.addObject("manufacture", manufacture);

        return mav;
    }

    @RequestMapping("/manufacture/delete/{id}")
    public String deleteManufacture(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/manufacture";
    }
}