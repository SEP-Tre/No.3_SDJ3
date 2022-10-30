package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product
{
    @Id
    private int productId;
    private String type;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }

}
