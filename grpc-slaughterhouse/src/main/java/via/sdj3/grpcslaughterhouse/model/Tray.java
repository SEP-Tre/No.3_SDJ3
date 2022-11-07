package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tray {
    @Id
    @GeneratedValue
    private int trayId;

    @JoinTable
    @OneToMany
    private List<Part> parts;
    private int weightCapacity;
    private String partName;

    public Tray() {
    }

    public List<Part> getParts()
    {
        return parts;
    }

    public void setParts(List<Part> parts)
    {
        this.parts = parts;
    }

    public int getTrayId()
    {
        return trayId;
    }

    public void setTrayId(int trayId)
    {
        this.trayId = trayId;
    }

    public int getWeightCapacity()
    {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity)
    {
        this.weightCapacity = weightCapacity;
    }

    public String getPartName()
    {
        return partName;
    }

    public void setPartName(String partName)
    {
        this.partName = partName;
    }
}