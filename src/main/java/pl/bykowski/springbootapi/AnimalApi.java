package pl.bykowski.springbootapi;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animal")
public class AnimalApi {

    private List<Animal> animals;

    public AnimalApi() {
        this.animals = new ArrayList<>();
    }

    @GetMapping
    public List<Animal> getAnimals() {
        return animals;
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.add(animal);
    }

    @PutMapping
    public boolean updateAnimal(@RequestBody Animal animal) {
        Optional<Animal> first = animals.stream()
                .filter(ani -> ani.getId().equals(animal.getId())).findFirst();
        if(first.isPresent()) {
            Animal animal1 = first.get();
            animal1.setAge(animal.getAge());
            animal1.setName(animal.getName());
            return true;
        }
        return false;
    }

    @DeleteMapping
    public boolean deleteAnimal(@RequestParam Long id) {
        return animals.removeIf(x -> x.getId().equals(id));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        Animal animal = new Animal();
        animal.setId(1L);
        animal.setName("Pucek");
        animal.setAge(11);
        animals.add(animal);
    }


}
