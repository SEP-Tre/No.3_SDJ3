package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;
// TODO: 07-11-2022 Error might be here. Wrong import. 

@Entity
public class Part
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partId;

    @JoinColumn(name = "animal_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Animal animal;
    private String partName;
    private float weight;
    // Needed to differentiate exactly what used meant. There are two different contexts for it
    private boolean isInTray;
    private boolean isInProduct;

    public Part()
    {
        isInTray = false;
        isInProduct = false;
    }

    public Part(Animal animal, String partName, float weight)
    {
        this.partId = 0;
        this.isInTray = false;
        this.isInProduct = false;
        this.animal = animal;
        this.partName = partName;
        this.weight = weight;
    }

    public boolean isInTray()
    {
        return isInTray;
    }

    public void setInTray(boolean inTray)
    {
        isInTray = inTray;
    }

    public boolean isInProduct()
    {
        return isInProduct;
    }

    public void setInProduct(boolean inProduct)
    {
        isInProduct = inProduct;
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

    @Override
    public String toString()
    {
        return "Part{" +
                "partId=" + partId +
                ", animal=" + animal +
                ", partName='" + partName + '\'' +
                ", weight=" + weight +
                ", isInTray=" + isInTray +
                ", isInProduct=" + isInProduct +
                '}';
    }
}
