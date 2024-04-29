package lessons.lesson_04_26;



import lessons.lesson_04_26.parserPatients.Parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1 Создать класс Patient
//2 Сделать парсер из строки в Patient
//3 Сделать картотеку, которая находит пациентов по id или имени и фамилии.
public class Clinik {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Path.of("patiens"));
        List<String> readList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            readList.add(scanner.nextLine());
        }

        System.out.println(readList);

        Cartoteka cartoteka = new Cartoteka(Parser.parsePatients(readList));

        System.out.println(cartoteka.searchPatientById("5"));
        System.out.println(cartoteka.searchPatientByNameOrSurname("Mitakov"));


    }
}