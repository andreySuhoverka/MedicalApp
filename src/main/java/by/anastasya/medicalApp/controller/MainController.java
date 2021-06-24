package by.anastasya.medicalApp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @GetMapping(path = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting
            (@RequestParam(name = "name", required = false, defaultValue = "World")
                     String name) {
        return "name=" + name;
    }

}

