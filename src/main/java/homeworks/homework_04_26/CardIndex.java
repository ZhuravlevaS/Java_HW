package homeworks.homework_04_26;

import java.util.*;

public class CardIndex {
    private final HashMap<Integer, Patient> patients = new HashMap<>();
    private final TreeMap<Patient, Integer> patientTreeMap = new TreeMap<>();
    public Patient searchPatientById(Integer id) {
        return patients.get(id);
    }

    public List<Patient> searchPatientByNameOrSurname(String name) {
        List<Patient> sameNamePatients = new ArrayList<>();
        for (Map.Entry<Patient, Integer> entry: this.patientTreeMap.entrySet()){
            Patient key = entry.getKey();
            if(key.getSurname().equals(name) || key.getName().equals(name)){
                sameNamePatients.add(key);
            }
        }
        return sameNamePatients;
    }

    public CardIndex(List<Patient> patients) {
        for (Patient patient: patients){
            this.patients.put(patient.getId(), patient);
            this.patientTreeMap.put(patient, patient.getId());
        }
        System.out.println(patientTreeMap);
    }
}
