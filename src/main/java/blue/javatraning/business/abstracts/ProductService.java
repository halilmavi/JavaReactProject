package blue.javatraning.business.abstracts;

import blue.javatraning.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
