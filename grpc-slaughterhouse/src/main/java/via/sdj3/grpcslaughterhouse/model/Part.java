package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;
import java.util.List;
// TODO: 07-11-2022 Error might be here. Wrong import. 

@Entity
public class Part
{
    @Id
    @GeneratedValue
    private int partId;

    @JoinColumn(name="animal_id", referencedColumnName = "animal_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Animal animal;
    private String partName;
    private float weight;

    public Part()
    {
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
