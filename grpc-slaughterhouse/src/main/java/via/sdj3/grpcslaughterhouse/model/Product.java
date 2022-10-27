package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product
{
    @Id
    private int productId;
    private int trayId;
    private String type;

    public Product() {
    }

    public Product(int productId, int trayId, String type)
    {
        this.productId = productId;
        this.trayId = trayId;
        this.type = type;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public int getTrayId()
    {
        return trayId;
    }

    public void setTrayId(int trayId)
    {
        this.trayId = trayId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
