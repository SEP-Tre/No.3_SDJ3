package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;
import java.util.List;
// TODO: 07-11-2022 Error might be here. Wrong import. 

@Entity
public class Part
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partId;

    @JoinColumn(name="animal_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Animal animal;
    private String partName;
    private float weight;

    private boolean isUsed;
    public Part()
    {
    }

    public Part(Animal animal, String partName, float weight)
    {
        this.partId = 0;
        this.isUsed=false;
        this.animal = animal;
        this.partName = partName;
        this.weight = weight;
    }

    public boolean isUsed()
    {
        return isUsed;
    }

    public void setUsed(boolean used)
    {
        isUsed = used;
    }

    public int getPartId()
    {
        return partId;
    }

    public void setPartId(int partId)
    {
        this.partId = partId;
    }

    public Animal getAnimal()
    {
        return animal;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
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
