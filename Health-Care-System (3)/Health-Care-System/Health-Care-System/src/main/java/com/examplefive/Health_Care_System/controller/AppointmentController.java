package com.examplefive.Health_Care_System.controller;

import com.examplefive.Health_Care_System.entity.Appointment;
import com.examplefive.Health_Care_System.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = " http://localhost:5173/")

@RestController

public class AppointmentController {
    @Autowired
    private AppointmentService AppointmentService;

    @GetMapping(path="/get")
    public List<Appointment> getAppointments()
    {
        return AppointmentService.getAppointments();
    }

    @GetMapping(path = "/appointments/{appointmentId}")
    public Appointment getAppointmentById(@PathVariable int appointmentId)
    {
        return AppointmentService.getAppointmentById(appointmentId);
    }

    @PostMapping(path = "/add")
    public Appointment bookAppointment(@RequestBody Appointment appointment )
    {
        return AppointmentService.bookAppointment(appointment);
    }

    @DeleteMapping(path = "/appointments/{appointmentId}")
    public void deleteAppointmentById(@PathVariable int appointmentId)
    {
        AppointmentService.deleteAppointmentById(appointmentId);
    }

    @GetMapping(path ="/appointments/{doctorId}" )
    public List<Appointment>getAppointmentByDoctor(@PathVariable int doctorId)
    {
        return AppointmentService.getAppointmentByDoctor(doctorId);
    }


}
