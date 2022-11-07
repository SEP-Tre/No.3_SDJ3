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
    private int weightCapacity;
    private String partName;
    private boolean isUsed;
    public Tray() {
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