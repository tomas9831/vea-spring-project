package cz.vsb.vea.cz.vsb.vea.lab02v2.controllers;
import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Worker;
import cz.vsb.vea.cz.vsb.vea.lab02v2.services.WorkerService;
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
public class WorkerController {
    @Autowired
    private WorkerService service;
    //private VehicleService vehicleService;

    @RequestMapping("/worker")
    public String viewHomePage(Model model){
        List<Worker> listWorkers = service.listAll();
        model.addAttribute("listWorkers",listWorkers);

        return "index_worker";
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/worker/new")
    public String showNewWorkerForm(Model model){
        Worker worker = new Worker();
        model.addAttribute("worker",worker);

        return "new_worker";
    }
    @RequestMapping(value = "/worker/" +
            "save", method = RequestMethod.POST)
    public String saveWorker(@ModelAttribute("worker") Worker worker) {
        service.save(worker);

        return "redirect:/worker";
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/worker/edit/{id}")
    public ModelAndView showEditWorkerPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_worker");
        Worker worker = service.get(id);
        mav.addObject("worker", worker);

        return mav;
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/worker/delete/{id}")
    public String deleteWorker(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
