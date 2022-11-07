package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product
{
    @Id
    @GeneratedValue
    private int productId;

    @JoinTable
    @OneToMany
    private List<Tray> trays;
    private String productType;

    public Product()
    {
    }

    public List<Tray> getTrays()
    {
        return trays;
    }

    public void setTrays(List<Tray> trays)
    {
        this.trays = trays;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getProductType()
    {
        return productType;
    }

    public void setProductType(String productType)
    {
        this.productType = productType;
    }
}
