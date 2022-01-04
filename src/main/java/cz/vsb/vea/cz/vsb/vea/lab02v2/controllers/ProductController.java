package cz.vsb.vea.cz.vsb.vea.lab02v2.controllers;

import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Product;
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
public class ProductController {
    @Autowired
    private ProductService service;
    //private VehicleService vehicleService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts",listProducts);

        return "index_product";
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);

        return "new_product";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/";
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }
    @Secured({"ROLE_EDITOR"})
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
