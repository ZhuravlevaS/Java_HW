package homeworks.homework_25_03.hw_27_03.components;

public class Laptop extends OfficeEquipment {
    private String processorType;
    private double ramSize;
    private double storageSize;
    private double batteryLife;
    private double screenSize;
    private String operatingSystem;
    private boolean isTouchscreen;

    public Laptop(String modelName,
                  String manufacturer,
                  int yearOfManufacture,
                  double price,
                  double weight,
                  boolean isOperational,
                  String processorType,
                  double ramSize,
                  double storageSize,
                  double batteryLife,
                  double screenSize,
                  String operatingSystem,
                  boolean isTouchscreen) {
        super(modelName,
                manufacturer,
                yearOfManufacture,
                price,
                weight,
                isOperational);
        this.processorType = processorType;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.batteryLife = batteryLife;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.isTouchscreen = isTouchscreen;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public double getRamSize() {
        return ramSize;
    }

    public void setRamSize(double ramSize) {
        this.ramSize = ramSize;
    }

    public double getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(double storageSize) {
        this.storageSize = storageSize;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public boolean isTouchscreen() {
        return isTouchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        isTouchscreen = touchscreen;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + " Laptop{" +
                "processorType='" + processorType + '\'' +
                ", ramSize=" + ramSize +
                ", storageSize=" + storageSize +
                ", batteryLife=" + batteryLife +
                ", screenSize=" + screenSize +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", isTouchscreen=" + isTouchscreen +
                '}';
    }
}
