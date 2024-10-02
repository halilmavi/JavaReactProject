package blue.javatraning.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {

    /*
      @OneToMany: Bu, bir varlık sınıfının (örneğin bir Category sınıfı) birden fazla Product ile ilişkili olduğunu belirtir.
      Yani, bir kategori birden fazla ürüne sahip olabilir. Örnek verecek olursak içecek kategorisine birden fazla ürün için kullanalabiliriz.
     */

    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
