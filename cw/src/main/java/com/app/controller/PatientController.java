package com.app.controller;

import com.app.entity.Patient;
import com.app.requests.Login;
import com.app.service.PatientService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = " http://localhost:5173/")

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
// view patients details
    @GetMapping(path = "/patients")
    public List<Patient> getAllPatient()
    {
        return patientService.getAllPatient();
    }
    // for sign up
    @PostMapping(path = "/patients")
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createPatient(patient);
    }

    @PostMapping("/loginUser")
    public Map<String, Boolean> loginUser(@RequestBody Login login) {
        // Call the loginUser method in the service
        Boolean loginSuccess = patientService.loginUser(login);

        // Prepare the response map
        Map<String, Boolean> response = new HashMap<>();
        response.put("success", loginSuccess);  // Store the result in the response map

        // Return the response map as JSON
        return response;
    }





}
