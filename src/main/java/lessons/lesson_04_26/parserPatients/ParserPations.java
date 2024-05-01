package lessons.lesson_04_26.parserPatients;

import lessons.lesson_04_26.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ParserPations {
    public static List<Patient> parsePatients(List<String> readList){
        List<Patient> patients = new ArrayList<>();

        for (String patient: readList) {
            String[] patientArray = patient.split(" ");

            patients.add(
                    new Patient(Integer.parseInt(
                    patientArray[0]),
                    patientArray[1],
                    patientArray[2],
                    LocalDate.parse(patientArray[3])));
        }

        return patients;
    }
}
