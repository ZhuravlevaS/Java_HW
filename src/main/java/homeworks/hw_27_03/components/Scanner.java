package homeworks.hw_27_03.components;

public class Scanner extends OfficeEquipment {
    private String scanResolution;
    private int scanSpeed;
    private String colorDepth;
    private String maxPaperSize;
    private String connectivity;
    private boolean isDuplexScanning;
    private String scannerType;

    public Scanner(String modelName,
                   String manufacturer,
                   int yearOfManufacture,
                   double price,
                   double weight,
                   boolean isOperational,
                   String scanResolution,
                   int scanSpeed,
                   String colorDepth,
                   String maxPaperSize,
                   String connectivity,
                   boolean isDuplexScanning,
                   String scannerType) {
        super(modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.scanResolution = scanResolution;
        this.scanSpeed = scanSpeed;
        this.colorDepth = colorDepth;
        this.maxPaperSize = maxPaperSize;
        this.connectivity = connectivity;
        this.isDuplexScanning = isDuplexScanning;
        this.scannerType = scannerType;
    }

    public String getScanResolution() {
        return scanResolution;
    }

    public void setScanResolution(String scanResolution) {
        this.scanResolution = scanResolution;
    }

    public int getScanSpeed() {
        return scanSpeed;
    }

    public void setScanSpeed(int scanSpeed) {
        this.scanSpeed = scanSpeed;
    }

    public String getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(String colorDepth) {
        this.colorDepth = colorDepth;
    }

    public String getMaxPaperSize() {
        return maxPaperSize;
    }

    public void setMaxPaperSize(String maxPaperSize) {
        this.maxPaperSize = maxPaperSize;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public boolean isDuplexScanning() {
        return isDuplexScanning;
    }

    public void setDuplexScanning(boolean duplexScanning) {
        isDuplexScanning = duplexScanning;
    }

    public String getScannerType() {
        return scannerType;
    }

    public void setScannerType(String scannerType) {
        this.scannerType = scannerType;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + " Scanner{" +
                "scanResolution='" + scanResolution + '\'' +
                ", scanSpeed=" + scanSpeed +
                ", colorDepth='" + colorDepth + '\'' +
                ", maxPaperSize='" + maxPaperSize + '\'' +
                ", connectivity='" + connectivity + '\'' +
                ", isDuplexScanning=" + isDuplexScanning +
                ", scannerType='" + scannerType + '\'' +
                '}';
    }
}
