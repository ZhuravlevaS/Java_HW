package homeworks.homework_25_03.hw_27_03.components;

public class Switch extends OfficeEquipment{
    private int portCount;
    private int speed;
    private String layer;
    private String managementType;
    private String powerOverEthernet;
    private String stackable;
    private String formFactor;

    public Switch(String modelName,
                  String manufacturer,
                  int yearOfManufacture,
                  double price,
                  double weight,
                  boolean isOperational,
                  int portCount,
                  int speed,
                  String layer,
                  String managementType,
                  String powerOverEthernet,
                  String stackable,
                  String formFactor) {
        super(modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.portCount = portCount;
        this.speed = speed;
        this.layer = layer;
        this.managementType = managementType;
        this.powerOverEthernet = powerOverEthernet;
        this.stackable = stackable;
        this.formFactor = formFactor;
    }

    public int getPortCount() {
        return portCount;
    }

    public void setPortCount(int portCount) {
        this.portCount = portCount;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getManagementType() {
        return managementType;
    }

    public void setManagementType(String managementType) {
        this.managementType = managementType;
    }

    public String getPowerOverEthernet() {
        return powerOverEthernet;
    }

    public void setPowerOverEthernet(String powerOverEthernet) {
        this.powerOverEthernet = powerOverEthernet;
    }

    public String getStackable() {
        return stackable;
    }

    public void setStackable(String stackable) {
        this.stackable = stackable;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + " Switch{" +
                "portCount=" + portCount +
                ", speed=" + speed +
                ", layer='" + layer + '\'' +
                ", managementType='" + managementType + '\'' +
                ", powerOverEthernet='" + powerOverEthernet + '\'' +
                ", stackable='" + stackable + '\'' +
                ", formFactor='" + formFactor + '\'' +
                '}';
    }
}
