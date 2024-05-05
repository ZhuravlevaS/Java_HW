package homeworks.homework_04_26.patientsParser;
import homeworks.homework_04_26.Patient;

import java.time.LocalDate;


public class PatientParse {
    public static Patient parsePatients(String patient){
        String[] patientArray = patient.split(" ");

        return new Patient(
                Integer.parseInt(patientArray[0]),
                patientArray[1],
                patientArray[2],
                LocalDate.parse(patientArray[3]));
    }

    private PatientParse(){}
}
