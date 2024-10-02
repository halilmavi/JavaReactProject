package blue.javatraning.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
1. **@Data** (Lombok):
   - Sınıf için otomatik olarak **getter**, **setter**, **toString()**, **equals()** ve **hashCode()** metodlarını oluşturur. Kısaca, veri modelinizin temel metotlarını yazmak zorunda kalmazsınız.

2. **@AllArgsConstructor** (Lombok):
   - Sınıftaki **tüm özellikleri parametre olarak alan bir constructor (yapıcı metot)** oluşturur. Böylece nesne oluştururken tüm alanları kolayca başlatabilirsiniz.

3. **@NoArgsConstructor** (Lombok):
   - **Parametresiz bir constructor** oluşturur. Özellikle JPA gibi framework'lerde ihtiyaç duyulan boş constructor'ı sağlar.

4. **@Table(name="products")** (JPA):
   - Bu sınıfın veritabanındaki hangi tabloyla ilişkilendirileceğini belirtir. `name` parametresiyle, sınıfın veri tabanında `products` isimli tabloya karşılık geldiğini söyler.

5. **@Entity** (JPA):
   - Bu sınıfın bir **veritabanı varlığı (entity)** olduğunu belirtir. JPA bu sınıfı veritabanında bir tablo olarak yönetir.

*/

@Data
@Entity
@Table(name= "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    /*
       @ManyToOne
       Bu ilişki, birden fazla ürünün (Product), bir kategoriye (Category) ait olduğunu ifade eder.
       Yani, bir Product varlığı, bir Category varlığı ile ilişkilidir, ancak bir kategori birden fazla ürüne sahip olabilir.

       @JoinColumn
       Join, bir tablodaki veriyi, bir başka tabloyla belirli bir ilişki kurarak birleştirir ve sonuç olarak iki tablodan da veri döndürür.
       Veritabanında veriyi tekrar etmeden, tutarlı ve organize bir şekilde saklamanıza yardımcı olur.
       Join ile ihtiyaç duyduğunuzda verileri birleştirip tek bir sorguda anlamlı sonuçlar elde ederiz.
       Örneğin, customers ve orders tablolarında müşteri bilgileri ve siparişler ayrı tutulur.
       Siparişlerle birlikte müşteri bilgilerini almak için bu iki tabloyu join ile birleştirirsiniz.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int id;

    // @Column(name="category_id")
   //  private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;


}
