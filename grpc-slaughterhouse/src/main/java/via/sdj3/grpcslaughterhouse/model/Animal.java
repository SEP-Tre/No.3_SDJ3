package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;

@Entity
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animal_id;
    private float weight;
    private String animal_type;

    private boolean isConverted;

    public Animal()
    {
    }

    public Animal(int animal_id, float weight, String animal_type, boolean isConverted)
    {
        this.animal_id = animal_id;
        this.weight = weight;
        this.animal_type = animal_type;
        this.isConverted = isConverted;
    }

    public boolean isConverted()
    {
        return isConverted;
    }

    public void setConverted(boolean converted)
    {
        isConverted = converted;
    }

    public int getAnimal_id()
    {
        return animal_id;
    }

    public void setAnimal_id(int animal_id)
    {
        this.animal_id = animal_id;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public String getAnimal_type()
    {
        return animal_type;
    }

    public void setAnimal_type(String animal_type)
    {
        this.animal_type = animal_type;
    }

    @Override
    public String toString()
    {
        return "Animal{" +
                "animal_id=" + animal_id +
                ", weight=" + weight +
                ", animal_type='" + animal_type + '\'' +
                ", isConverted=" + isConverted +
                '}';
    }
}
