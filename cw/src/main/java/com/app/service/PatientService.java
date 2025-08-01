package com.app.service;

import com.app.entity.Patient;
import com.app.repository.PatientRepository;
import com.app.requests.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
//for get details
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }
//for sign up
    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }



    // Login method in patientService
    public Boolean loginUser(Login login) {
        // Fetch patient by username
        Patient patient = patientRepository.findByUserName(login.getUserName());

        // If patient is not found, return false
        if (patient == null) {
            return false;
        }

        // Retrieve stored password & compare with user input
        return patient.getPassword().equals(login.getPassword());
    }


}
