package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tray
{
    @Id
    private int tray_id;
    private int part_id;
    private String part_name;
    private int weight_capacity;

    public int getWeight_capacity() {
        return weight_capacity;
    }

    public void setWeight_capacity(int weight_capacity) {
        this.weight_capacity = weight_capacity;
    }

    public Tray() {
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

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    @Override
    public String toString() {
        return "Tray{" +
                "tray_id=" + tray_id +
                ", part_id=" + part_id +
                ", part_name='" + part_name + '\'' +
                ", weight_capacity=" + weight_capacity +
                '}';
    }
}
