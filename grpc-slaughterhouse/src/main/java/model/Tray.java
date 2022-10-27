package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tray
{
    @Id
    private int trayId;
    private int partId;
    private String partName;

    public int getTrayId()
    {
        return trayId;
    }

    public void setTrayId(int trayId)
    {
        this.trayId = trayId;
    }

    public int getPartId()
    {
        return partId;
    }

    public void setPartId(int partId)
    {
        this.partId = partId;
    }

    public String getPartName()
    {
        return partName;
    }

    public void setPartName(String partName)
    {
        this.partName = partName;
    }

    public float getWeightCapacity()
    {
        return weightCapacity;
    }

    public void setWeightCapacity(float weightCapacity)
    {
        this.weightCapacity = weightCapacity;
    }

    private float weightCapacity;

    public Tray(int trayId, int partId, String partName, float weightCapacity)
    {
        this.trayId = trayId;
        this.partId = partId;
        this.partName = partName;
        this.weightCapacity = weightCapacity;
    }
}
