package homeworks.hw_27_03.utils;

import homeworks.hw_27_03.components.OfficeEquipment;

import java.util.Arrays;
import java.util.Objects;
public class Methods {
    public static void printAllEquipment(OfficeEquipment[] officeEquipmentArray) {
        for (OfficeEquipment officeEquipment: officeEquipmentArray) {
            System.out.println(officeEquipment);
        }
    }

    public static double calculateTotalPrice(OfficeEquipment[] officeEquipmentArray) {
        double totalPrice = 0;
        for (OfficeEquipment officeEquipment: officeEquipmentArray) {
            totalPrice += officeEquipment.getPrice();
        }

        return totalPrice;
    }

    public static void listByManufacturer(OfficeEquipment[] officeEquipmentArray, String manufacturer) {
        OfficeEquipment[] newArray = new OfficeEquipment[officeEquipmentArray.length];
        int currentIdx = 0;
        for (OfficeEquipment officeEquipment: officeEquipmentArray) {
            if(manufacturer.equals(officeEquipment.getManufacturer())) {
                newArray[currentIdx] = officeEquipment;
                currentIdx ++;
            }
        }
        Arrays.stream(newArray).filter(x-> !Objects.isNull(x)).forEach(System.out::println);

    }

    public static int findOldestEquipment(OfficeEquipment[] officeEquipmentArray) {
        int oldestYear = officeEquipmentArray[0].getYearOfManufacture();

        for (OfficeEquipment officeEquipment: officeEquipmentArray) {
           if (officeEquipment.getYearOfManufacture() < oldestYear) {
               oldestYear = officeEquipment.getYearOfManufacture();
           }
        }
        return oldestYear;
    }

    public static int countOperational(OfficeEquipment[] officeEquipmentArray) {
        int countOperating = 0;

        for (OfficeEquipment officeEquipment: officeEquipmentArray) {
            if (officeEquipment.isOperational()) {
               countOperating++;
            }
        }
        return countOperating;
    }
}
