package blue.javatraning.api.controllers;

import blue.javatraning.business.abstracts.ProductService;
import blue.javatraning.core.utilities.results.DataResult;
import blue.javatraning.core.utilities.results.ErrorDataResult;
import blue.javatraning.core.utilities.results.Result;
import blue.javatraning.core.utilities.results.SuccessDataResult;
import blue.javatraning.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    //
    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product){
        return this.productService.add(product);
    }
}
