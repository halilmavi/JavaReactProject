package blue.javatraning.business.concretes;

import blue.javatraning.business.abstracts.ProductService;
import blue.javatraning.core.utilities.results.DataResult;
import blue.javatraning.core.utilities.results.Result;
import blue.javatraning.core.utilities.results.SuccessDataResult;
import blue.javatraning.core.utilities.results.SuccessResult;
import blue.javatraning.dataAccess.abstracts.ProductDao;
import blue.javatraning.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    //Burada DataResult tipinde tanımlamamızın sebebi metodun sonucu success de olabilir error da olabilir o yüzden ikisininde base classı olan DataResult olarak tanımladık.
    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productDao.findAll(),"Product added !");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);

        return new SuccessResult("Product added");
    }
}
