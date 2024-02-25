package com.Practo.Service;

import com.Practo.Entity.Patient;
import com.Practo.Repositary.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        return optionalPatient.orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setName(updatedPatient.getName());
            existingPatient.setDiease(updatedPatient.getDiease());
            existingPatient.setAge(updatedPatient.getAge());
            return patientRepository.save(existingPatient);
        } else {
            return null;
        }
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
