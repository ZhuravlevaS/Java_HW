package homeworks.homework_25_03.hw_27_03.components;

public class Router extends OfficeEquipment {
    private int speed;
    private String band;
    private String security;
    private String ports;
    private String range;
    private boolean isDualBand;
    private String connectivityType;

    public Router(String modelName,
                  String manufacturer,
                  int yearOfManufacture,
                  double price,
                  double weight,
                  boolean isOperational,
                  int speed,
                  String band,
                  String security,
                  String ports,
                  String range,
                  boolean isDualBand,
                  String connectivityType) {
        super(modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.speed = speed;
        this.band = band;
        this.security = security;
        this.ports = ports;
        this.range = range;
        this.isDualBand = isDualBand;
        this.connectivityType = connectivityType;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public boolean isDualBand() {
        return isDualBand;
    }

    public void setDualBand(boolean dualBand) {
        isDualBand = dualBand;
    }

    public String getConnectivityType() {
        return connectivityType;
    }

    public void setConnectivityType(String connectivityType) {
        this.connectivityType = connectivityType;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + "Router{" +
                "speed=" + speed +
                ", band='" + band + '\'' +
                ", security='" + security + '\'' +
                ", ports='" + ports + '\'' +
                ", range='" + range + '\'' +
                ", isDualBand=" + isDualBand +
                ", connectivityType='" + connectivityType + '\'' +
                '}';
    }
}
