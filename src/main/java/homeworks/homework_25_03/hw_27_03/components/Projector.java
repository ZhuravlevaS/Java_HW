package homeworks.homework_25_03.hw_27_03.components;

public class Projector extends OfficeEquipment {
    private String lumens;
    private String resolution;
    private String contrastRatio;
    private int lampLife;
    private String projectionSize;
    private String connectivity;
    private boolean is3DReady;

    public Projector(String modelName,
                     String manufacturer,
                     int yearOfManufacture,
                     double price,
                     double weight,
                     boolean isOperational,
                     String lumens,
                     String resolution,
                     String contrastRatio,
                     int lampLife,
                     String projectionSize,
                     String connectivity,
                     boolean is3DReady) {
        super(modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.lumens = lumens;
        this.resolution = resolution;
        this.contrastRatio = contrastRatio;
        this.lampLife = lampLife;
        this.projectionSize = projectionSize;
        this.connectivity = connectivity;
        this.is3DReady = is3DReady;
    }

    public String getLumens() {
        return lumens;
    }

    public void setLumens(String lumens) {
        this.lumens = lumens;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getContrastRatio() {
        return contrastRatio;
    }

    public void setContrastRatio(String contrastRatio) {
        this.contrastRatio = contrastRatio;
    }

    public int getLampLife() {
        return lampLife;
    }

    public void setLampLife(int lampLife) {
        this.lampLife = lampLife;
    }

    public String getProjectionSize() {
        return projectionSize;
    }

    public void setProjectionSize(String projectionSize) {
        this.projectionSize = projectionSize;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public boolean isIs3DReady() {
        return is3DReady;
    }

    public void setIs3DReady(boolean is3DReady) {
        this.is3DReady = is3DReady;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + " Projector{" +
                "lumens='" + lumens + '\'' +
                ", resolution='" + resolution + '\'' +
                ", contrastRatio='" + contrastRatio + '\'' +
                ", lampLife=" + lampLife +
                ", projectionSize='" + projectionSize + '\'' +
                ", connectivity='" + connectivity + '\'' +
                ", is3DReady=" + is3DReady +
                '}';
    }
}
