package homeworks.hw_27_03.components;

public class OfficeEquipment {
    private int id;
    private static int countId = 0;
    private String modelName;
    private String manufacturer;
    private int yearOfManufacture;
    private double price;
    private double weight;
    private boolean isOperational;

    public OfficeEquipment(String modelName,
                           String manufacturer,
                           int yearOfManufacture,
                           double price,
                           double weight,
                           boolean isOperational) {
        this.id = countId + 1;
        countId++;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture + 1900;
        this.price = price;
        this.weight = weight;
        this.isOperational = isOperational;
    }

    public int getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public void setOperational(boolean operational) {
        isOperational = operational;
    }

    @Override
    public String toString() {
        return "OfficeEquipment{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                '}';
    }
}
