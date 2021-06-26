package by.anastasya.medicalApp.dao;

import java.util.List;

import by.anastasya.medicalApp.entity.Doctor;

public interface UserDao {

  List<Doctor> getDoctorsBySpeciality(String speciality);

}
