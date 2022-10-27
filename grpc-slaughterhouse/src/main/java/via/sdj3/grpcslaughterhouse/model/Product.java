package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product
{
    @Id
    private int product_id;
    private int tray_id;
    private String type;

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getTray_id() {
        return tray_id;
    }

    public void setTray_id(int tray_id) {
        this.tray_id = tray_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", tray_id=" + tray_id +
                ", type='" + type + '\'' +
                '}';
    }
}
