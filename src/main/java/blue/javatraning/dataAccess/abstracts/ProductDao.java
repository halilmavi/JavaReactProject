package blue.javatraning.dataAccess.abstracts;

import blue.javatraning.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// JpaRepository, JPA kullanarak temel CRUD (Create, Read, Update, Delete) işlemlerini otomatik olarak gerçekleştiren metodları içerir.
public interface ProductDao extends JpaRepository<Product,Integer> {

    /*
        " getByProductName " Bu metod, özelleştirilmiş bir sorgu metodudur. JPA, metod isimlerini anlamlandırarak otomatik olarak SQL sorguları oluşturabilir.
        Yani, metodun adı, veritabanında hangi işlemin yapılacağını belirler.
        Bu tür özelleştirilmiş sorgularla, doğrudan repository arayüzüne metod ekleyerek karmaşık SQL sorguları yazmadan belirli alanlara göre veri sorgulama işlemleri yapabiliriz.

        findBy: Verilen özellik(ler)e göre bir veya daha fazla kayıt bulur.
        getBy: findBy ile benzer şekilde çalışır, ancak mantıksal olarak bir tekil kayıt beklenir.
        readBy: Veritabanından bir kayıt okunur.
        queryBy: Bir sorgu yapılacağını belirtir.
        countBy: Verilen kriterlere göre kaç kayıt olduğunu döndürür.
        existsBy: Verilen kriterlere göre bir kaydın var olup olmadığını kontrol eder.

        getByProductNameAndCategoryId mesela bu metodumuzda yine get sorgusunu kullandık ama isimlendirirken "And" operatoru kullanarak nasıl
        bir işlem yapacağımız bu şekilde metot ismiyle oluşturabiliyoruz.
     */
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

}
