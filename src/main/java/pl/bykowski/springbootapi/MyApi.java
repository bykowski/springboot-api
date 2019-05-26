package pl.bykowski.springbootapi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyApi {

    @GetMapping("/hello")
    public Animal get() {
        Animal animal = new Animal();
        animal.setName("Pucek");
        animal.setAge(9);
        return animal;
    }

    @PostMapping("/hello")
    public String post() {
        return "post";
    }

    @DeleteMapping("/hello")
    public String delete() {
        return "delete";
    }
}
