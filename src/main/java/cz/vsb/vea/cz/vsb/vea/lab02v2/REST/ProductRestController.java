package cz.vsb.vea.cz.vsb.vea.lab02v2.REST;
import cz.vsb.vea.cz.vsb.vea.lab02v2.models.Product;
import cz.vsb.vea.cz.vsb.vea.lab02v2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/api/products", method = RequestMethod.GET)
    public List<Product> getAll() {
        return productService.listAll();
    }

    @RequestMapping(path = "/api/products/{id}", method = RequestMethod.GET)
    public Product find(@PathVariable long id) {
        return productService.get(id);
    }

    @RequestMapping(path = "/api/products", method = RequestMethod.POST)
    public void create(@Validated @RequestBody Product product) {
        productService.save(product);
    }

    @RequestMapping(path = "/api/products/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }
}
