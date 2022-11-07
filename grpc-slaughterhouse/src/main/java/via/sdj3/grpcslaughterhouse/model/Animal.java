package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;

@Entity
public class Animal
{
    @Id
    @GeneratedValue
    private int animal_id;
    private float weight;
    private String animal_type;

    public Animal()
    {
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
}
