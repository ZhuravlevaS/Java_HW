package homeworks.homework_25_03.hw_27_03.components;

public class Tablet extends OfficeEquipment {
    private String screenSize;
    private int storageSize;
    private String operatingSystem;
    private int batteryLife;
    private boolean isCellular;
    private String cameraResolution;
    private String processorType;

    public Tablet(String modelName,
                  String manufacturer,
                  int yearOfManufacture,
                  double price,
                  double weight,
                  boolean isOperational,
                  String screenSize,
                  int storageSize,
                  String operatingSystem,
                  int batteryLife,
                  boolean isCellular,
                  String cameraResolution,
                  String processorType) {
        super(modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.batteryLife = batteryLife;
        this.isCellular = isCellular;
        this.cameraResolution = cameraResolution;
        this.processorType = processorType;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isCellular() {
        return isCellular;
    }

    public void setCellular(boolean cellular) {
        isCellular = cellular;
    }

    public String getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(String cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + "Tablet{" +
                "screenSize='" + screenSize + '\'' +
                ", storageSize=" + storageSize +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", batteryLife=" + batteryLife +
                ", isCellular=" + isCellular +
                ", cameraResolution='" + cameraResolution + '\'' +
                ", processorType='" + processorType + '\'' +
                '}';
    }
}
