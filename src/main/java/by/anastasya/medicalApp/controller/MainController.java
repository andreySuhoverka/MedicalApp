package by.anastasya.medicalApp.controller;

import java.util.List;

import by.anastasya.medicalApp.dao.UserDao;
import by.anastasya.medicalApp.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @Autowired
    private UserDao userDao;

    @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting
            (@RequestParam(name = "name", required = false, defaultValue = "World")
                     String name) {
        return "name=" + name;
    }

    @GetMapping(path = "/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Doctor> getDoctorsBySpeciality(String speciality) {
        return userDao.getDoctorsBySpeciality(speciality);
    }

}

