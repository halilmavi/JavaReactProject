package blue.javatraning.business.abstracts;

import blue.javatraning.core.utilities.results.DataResult;
import blue.javatraning.core.utilities.results.Result;
import blue.javatraning.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);

}
