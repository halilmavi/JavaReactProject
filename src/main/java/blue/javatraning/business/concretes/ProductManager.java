package blue.javatraning.business.concretes;

import blue.javatraning.business.abstracts.ProductService;
import blue.javatraning.core.utilities.results.DataResult;
import blue.javatraning.core.utilities.results.Result;
import blue.javatraning.core.utilities.results.SuccessDataResult;
import blue.javatraning.core.utilities.results.SuccessResult;
import blue.javatraning.dataAccess.abstracts.ProductDao;
import blue.javatraning.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return new SuccessDataResult<List<Product>>(productDao.findAll(),"Product Listed !");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort));
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);

        return new SuccessResult("Product added");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName),"Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        //business codes

        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategoryIn(categories),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
    }


    /*
        Pageable: Spring Data JPA'nın sayfalama işlemlerini gerçekleştirmek için kullandığı bir arayüzdür. Verilerin sayfa sayfa getirilmesini sağlar.
        PageRequest.of(pageNo, pageSize): Veritabanından hangi sayfanın ve her sayfada kaç adet kaydın getirileceğini belirtir.
        pageNo sayfa numarasını, pageSize ise sayfadaki kayıt sayısını belirler.
     */
    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

}
