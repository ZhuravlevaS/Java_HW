package homeworks.hw_27_03;

import homeworks.hw_27_03.components.OfficeEquipment;
import homeworks.hw_27_03.utils.GenerateMockData;
import homeworks.hw_27_03.utils.Methods;

public class Main {
    public static void main(String[] args) {
        OfficeEquipment[] officeEquipmentArray = GenerateMockData.getRandomData(10);

        Methods.printAllEquipment(officeEquipmentArray);
        System.out.println(Methods.calculateTotalPrice(officeEquipmentArray));
        Methods.listByManufacturer(officeEquipmentArray, officeEquipmentArray[5].getManufacturer());
        System.out.println(Methods.findOldestEquipment(officeEquipmentArray));
        System.out.println(Methods.countOperational(officeEquipmentArray));
    }
}
