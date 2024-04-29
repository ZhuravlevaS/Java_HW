package homeworks.homework_25_03.hw_27_03;

import homeworks.homework_25_03.hw_27_03.components.OfficeEquipment;
import homeworks.homework_25_03.hw_27_03.utils.GenerateMockData;
import homeworks.homework_25_03.hw_27_03.utils.Methods;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        OfficeEquipment[] officeEquipmentArray = GenerateMockData.getRandomData(10);

        Methods.printAllEquipment(officeEquipmentArray);
        System.out.println(Methods.calculateTotalPrice(officeEquipmentArray));
        Methods.listByManufacturer(officeEquipmentArray, officeEquipmentArray[5].getManufacturer());
        System.out.println(Methods.findOldestEquipment(officeEquipmentArray));
        System.out.println(Methods.countOperational(officeEquipmentArray));

        OfficeEquipment equipOfYear = Methods.findEquipmentOfYear(officeEquipmentArray, officeEquipmentArray[5].getYearOfManufacture());

        if(Objects.isNull(equipOfYear)) {
            System.out.println("there is no equipment with this year");
        } else {
            System.out.println(equipOfYear);
        }
    }
}
