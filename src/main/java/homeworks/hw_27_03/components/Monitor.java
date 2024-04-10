package homeworks.hw_27_03.components;

public class Monitor extends OfficeEquipment {
    private double screenSize;
    private String resolution;
    private String panelType;
    private String refreshRate;
    private boolean isCurved;
    private boolean isHDR;
    private String ports;

    public Monitor(String modelName,
                   String manufacturer,
                   int yearOfManufacture,
                   double price,
                   double weight,
                   boolean isOperational,
                   double screenSize,
                   String resolution,
                   String panelType,
                   String refreshRate,
                   boolean isCurved,
                   boolean isHDR,
                   String ports) {
        super(modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.panelType = panelType;
        this.refreshRate = refreshRate;
        this.isCurved = isCurved;
        this.isHDR = isHDR;
        this.ports = ports;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getPanelType() {
        return panelType;
    }

    public void setPanelType(String panelType) {
        this.panelType = panelType;
    }

    public String getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(String refreshRate) {
        this.refreshRate = refreshRate;
    }

    public boolean isCurved() {
        return isCurved;
    }

    public void setCurved(boolean curved) {
        isCurved = curved;
    }

    public boolean isHDR() {
        return isHDR;
    }

    public void setHDR(boolean HDR) {
        isHDR = HDR;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + " Monitor{" +
                "screenSize=" + screenSize +
                ", resolution='" + resolution + '\'' +
                ", panelType='" + panelType + '\'' +
                ", refreshRate='" + refreshRate + '\'' +
                ", isCurved=" + isCurved +
                ", isHDR=" + isHDR +
                ", ports='" + ports + '\'' +
                '}';
    }
}
