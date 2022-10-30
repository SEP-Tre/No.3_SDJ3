package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tray {
    @Id
    private int trayId;
    private int weight_capacity;

    public Tray() {
    }

    public int getTrayId() {
        return trayId;
    }

    public int getWeight_capacity() {
        return weight_capacity;
    }

    @Override
    public String toString() {
        return "Tray{" +
                "trayId=" + trayId +
                ", weight_capacity=" + weight_capacity +
                '}';
    }
}