import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "../css/doctorView.css"; // Importing the CSS file
import axios from "axios";

const DoctorTable = () => {
  const navigate = useNavigate();
  const [doctors, setDoctors] = useState([]);

  // Fetch doctor data from the database
  useEffect(() => {
    const fetchDoctors = async () => {
      try {
        const response = await axios.get("http://localhost:8083/cw-app/doctors"); // Fetch doctor data from the entity microservice
        const filteredDoctors = response.data.map(doctor => ({
          id: doctor.doctorId,
          name: doctor.doctorName,
          speciality: doctor.speciality, // Make sure this matches the API response field
          charge: doctor.doctorFee
        }));
        setDoctors(filteredDoctors);
      } catch (error) {
        console.error("Error fetching doctor data:", error);
      }
    };

    fetchDoctors();
  }, []);

  const handleBookAppointment = (doctor) => {
    navigate("/appointment", {
      state: {
        doctorId: doctor.id,
        doctorName: doctor.name,
        speciality: doctor.speciality,
        doctorCharge: doctor.charge,
      },
    });
  };

  return (
    <div className="doctor-table-container">
      <h2>Doctor List</h2>
      <table className="doctor-table">
        <thead>
          <tr>
            <th>Doctor ID</th>
            <th>Name</th>
            <th>Speciality</th>
            <th>Charge (LK)</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {doctors.map((doctor) => (
            <tr key={doctor.id}>
              <td>{doctor.id}</td>
              <td>{doctor.name}</td>
              <td>{doctor.speciality}</td>
              <td>{doctor.charge}</td>
              <td>
                <button className="appointment-btn" onClick={() => handleBookAppointment(doctor)}>
                  Book Appointment
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default DoctorTable;