package homeworks.homework_04_26;




import homeworks.homework_04_26.parserPatients.ParserPatient;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1 Создать класс Patient
//2 Сделать парсер из строки в Patient
//3 Сделать картотеку, которая находит пациентов по id или имени и фамилии.
public class Hospital {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Path.of("patiens"));
        List<String> readList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            readList.add(scanner.nextLine());
        }

        System.out.println(readList);

        List<Patient> patients = new ArrayList<>();

        for (String s: readList){
            patients.add(ParserPatient.parsePatients(s));
        }

        CardIndex cardIndex = new CardIndex(patients);
        System.out.println(cardIndex.searchPatientById(5));
        System.out.println(cardIndex.searchPatientByNameOrSurname("Ale"));
    }
}
