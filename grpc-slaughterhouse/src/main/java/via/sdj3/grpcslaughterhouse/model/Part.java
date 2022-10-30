package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Part
{
    @Id
    private int partId;
    private int animalId;
    private String partName;
    private float weight;

    public Part() {
    }

    @Override
    public String toString() {
        return "Part{" +
                "partId=" + partId +
                ", animalId=" + animalId +
                ", partName='" + partName + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getPartId() {
        return partId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getPartName() {
        return partName;
    }

    public float getWeight() {
        return weight;
    }
}
