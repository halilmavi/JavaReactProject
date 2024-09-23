package blue.javatraning.business.concretes;

import blue.javatraning.business.abstracts.ProductService;
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

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }
}
