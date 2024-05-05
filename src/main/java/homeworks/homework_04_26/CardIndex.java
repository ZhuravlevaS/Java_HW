package homeworks.homework_04_26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class CardIndex {
    private final HashMap<Integer, Patient> patients = new HashMap<>();
    private final TreeSet<Patient> patientTreeSet = new TreeSet<Patient>();
    public Patient searchPatientById(Integer id) {
        return patients.get(id);
    }

    public List<Patient> searchPatientByNameOrSurname(String name) {
        List<Patient> sameNamePatients = new ArrayList<>();
        for (Patient patient: patientTreeSet){
            if(patient.getSurname().equals(name) || patient.getName().equals(name)){
                sameNamePatients.add(patient);
            }
        }
        return sameNamePatients;
    }

    public CardIndex(List<Patient> patients) {
        for (Patient patient: patients){
            this.patients.put(patient.getId(), patient);
            this.patientTreeSet.add(patient);
        }
        System.out.println(patientTreeSet);
    }
}
