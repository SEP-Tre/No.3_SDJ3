package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Part
{
    @Id
    private int part_id;
    private int animal_id;
    private String part_name;
    private float weight;

    public Part() {
    }

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Part{" +
                "part_id=" + part_id +
                ", animal_id=" + animal_id +
                ", part_name='" + part_name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
