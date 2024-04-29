package homeworks.homework_25_03.hw_27_03.components;

public class Printer extends OfficeEquipment {
    private String printTechnology;
    private int printSpeed;
    private String maxResolution;
    private boolean isColor;
    private String paperSize;
    private String connectivity;
    private String dutyCycle;

    public Printer(String modelName,
                   String manufacturer,
                   int yearOfManufacture,
                   double price,
                   double weight,
                   boolean isOperational,
                   String printTechnology,
                   int printSpeed,
                   String maxResolution,
                   boolean isColor,
                   String paperSize,
                   String connectivity,
                   String dutyCycle) {
        super(modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.printTechnology = printTechnology;
        this.printSpeed = printSpeed;
        this.maxResolution = maxResolution;
        this.isColor = isColor;
        this.paperSize = paperSize;
        this.connectivity = connectivity;
        this.dutyCycle = dutyCycle;
    }

    public String getPrintTechnology() {
        return printTechnology;
    }

    public void setPrintTechnology(String printTechnology) {
        this.printTechnology = printTechnology;
    }

    public int getPrintSpeed() {
        return printSpeed;
    }

    public void setPrintSpeed(int printSpeed) {
        this.printSpeed = printSpeed;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    public boolean isColor() {
        return isColor;
    }

    public void setColor(boolean color) {
        isColor = color;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    public String getDutyCycle() {
        return dutyCycle;
    }

    public void setDutyCycle(String dutyCycle) {
        this.dutyCycle = dutyCycle;
    }

    @Override
    public String toString() {
        String superStr = super.toString();
        return superStr + " Printer{" +
                "printTechnology='" + printTechnology + '\'' +
                ", printSpeed=" + printSpeed +
                ", maxResolution='" + maxResolution + '\'' +
                ", isColor=" + isColor +
                ", paperSize='" + paperSize + '\'' +
                ", connectivity='" + connectivity + '\'' +
                ", dutyCycle='" + dutyCycle + '\'' +
                '}';
    }
}
