package lessons.lesson_10_04;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Address {
    @Setter
    private Country country;
    @Setter
    private String street;
    @Setter
    private String houseNumber;
    private boolean isHouse = false;
    private int flatNumber;

    public void setHouse(boolean house) {
        isHouse = house;
    }

    public void setFlatNumber(int flatNumber) {
        if(isHouse){
            this.flatNumber = 0;
        } else {
            this.flatNumber = flatNumber;
        }

    }

    public Address(Country country, String street, String houseNumber, boolean isHouse, int flatNumber) {
        this.country = country;
        this.street = street;
        this.houseNumber = houseNumber;
        this.isHouse = isHouse;

        if(isHouse){
            this.flatNumber = 0;
        } else {
            this.flatNumber = flatNumber;
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "country=" + country +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", isHouse=" + isHouse +
                ", flatNumber=" + flatNumber +
                '}';
    }
}
