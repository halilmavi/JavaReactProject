package blue.javatraning.dataAccess.abstracts;

import blue.javatraning.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository, JPA kullanarak temel CRUD (Create, Read, Update, Delete) işlemlerini otomatik olarak gerçekleştiren metodları içerir.
public interface ProductDao extends JpaRepository<Product,Integer> {

}
