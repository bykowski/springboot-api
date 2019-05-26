package pl.bykowski.springbootapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApi {

    @GetMapping("/hello")
    public String get() {
        return "Hello";
    }

}
