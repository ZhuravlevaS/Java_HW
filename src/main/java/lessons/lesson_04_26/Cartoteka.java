package lessons.lesson_04_26;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Cartoteka {
    private List<Patient> patients;

    public Patient searchPatientById(String id) {
        for (Patient patient: patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public Patient searchPatientByNameOrSurname(String searchString) {
        for (Patient patient: patients) {
            if (patient.getName().equals(searchString) || patient.getSurname().equals(searchString)) {
                return patient;
            }
        }
        return null;
    }
}
