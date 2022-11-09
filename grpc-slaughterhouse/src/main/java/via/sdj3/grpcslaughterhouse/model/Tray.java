package via.sdj3.grpcslaughterhouse.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tray {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trayId;

    @JoinTable
    @OneToMany
    private List<Part> parts;
    private float weightCapacity;
    private String partName;
    private boolean isUsed;
    public Tray() {
        isUsed=false;
    }

    public Tray(List<Part> parts, int weightCapacity, String partName)
    {
        this.parts = parts;
        this.weightCapacity = weightCapacity;
        this.partName = partName;
        isUsed=false;
    }

    public boolean isUsed()
    {
        return isUsed;
    }

    public void setUsed(boolean used)
    {
        isUsed = used;
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

    public void addPart(Part part)
    {
        parts.add(part);
    }

    public void setTrayId(int trayId)
    {
        this.trayId = trayId;
    }

    public float getWeightCapacity()
    {
        return weightCapacity;
    }

    public void setWeightCapacity(float weightCapacity)
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