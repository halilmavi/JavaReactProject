package blue.javatraning.api.controllers;

import blue.javatraning.business.abstracts.ProductService;
import blue.javatraning.core.utilities.results.DataResult;
import blue.javatraning.core.utilities.results.Result;
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
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    //
    @PostMapping("/add")
    public Result addProduct(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, int categoryId) {
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName, int categoryId) {
        return this.productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryIn")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
        return this.productService.getByCategoryIdIn(categories);
    }


    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartingWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName, int categoryId) {
        return this.productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo-1,pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }


}


























