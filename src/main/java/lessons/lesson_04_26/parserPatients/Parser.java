package lessons.lesson_04_26.parserPatients;

import lessons.lesson_04_26.Patient;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Patient> parsePatients(List<String> readList){
        List<Patient> patients = new ArrayList<>();

        for (String patient: readList) {
            String[] patientArray = patient.split(" ");

            patients.add(new Patient(patientArray[0], patientArray[1], patientArray[2], patientArray[3]));
        }

        return patients;
    }
}
