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
    @Id
    private int productId;

    @Id
    private int trayId;
    @Id
    private int partId;

    private String type;
    private String partName;

    private int animalId;
    private double weight;

    public ProductTrace() {
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
        return "\nProduct "+productId+" trace:"     + "\n"  +
                "--Product ID:      " +productId    + "\n"  +
                "--Tray ID:         " +trayId       + "\n"  +
                "--Part ID:         " +partId       + "\n"  +
                "--Animal ID:       " +animalId     + "\n"  +
                "--Part name:       " +partName     + "\n"  +
                "--Product name:    " +type         + "\n"  +
                "--Part weight:     " +weight       + "\n"  ;

    }
}
