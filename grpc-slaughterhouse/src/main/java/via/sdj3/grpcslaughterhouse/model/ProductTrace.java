package via.sdj3.grpcslaughterhouse.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Immutable
@IdClass(ProductTraceId.class)
public class ProductTrace {
    // TODO: 30-10-2022 clean here and db
    private int id;
    @Id
    private int productId;
    private String type;
    @Id
    private int trayId;
    @Id
    private int partId;
    private String partName;

    private int animalId;
    private double weight;

    public ProductTrace() {
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public String getType() {
        return type;
    }

    public int getTrayId() {
        return trayId;
    }

    public int getPartId() {
        return partId;
    }

    public String getPartName() {
        return partName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\nProductTrace{" +
                "id=" + id +
                ", productId=" + productId +
                ", type='" + type  +
                ", trayId=" + trayId +
                ",\n partId=" + partId +
                ", partName='" + partName +
                ", animalId=" + animalId +
                ", weight=" + weight +
                '}';
    }
}
