package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product_trace {

    @Id
    private int product_id;
    private String type;
    private int tray_id;
    private int part_id;
    private double weight;

    public Product_trace() {
    }

    @Override
    public String toString() {
        return "Product_trace{" +
                "product_id=" + product_id +
                ", type='" + type + '\'' +
                ", tray_id=" + tray_id +
                ", part_id=" + part_id +
                ", weight=" + weight +
                '}';
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTray_id() {
        return tray_id;
    }

    public void setTray_id(int tray_id) {
        this.tray_id = tray_id;
    }

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
