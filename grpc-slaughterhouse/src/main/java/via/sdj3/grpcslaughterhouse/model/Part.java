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

    public Part(int partId, int animalId, String partName, float weight)
    {
        this.partId = partId;
        this.animalId = animalId;
        this.partName = partName;
        this.weight = weight;
    }

    public int getPartId()
    {
        return partId;
    }

    public void setPartId(int partId)
    {
        this.partId = partId;
    }

    public int getAnimalId()
    {
        return animalId;
    }

    public void setAnimalId(int animalId)
    {
        this.animalId = animalId;
    }

    public String getPartName()
    {
        return partName;
    }

    public void setPartName(String partName)
    {
        this.partName = partName;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }
}
