package pl.bykowski.springbootapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/animal")
public class AnimalApi {

    private AnimalRepo animalRepo;

    @Autowired
    public AnimalApi(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @GetMapping
    public Iterable<Animal> getAnimals() {
        return animalRepo.findAll();
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animalRepo.save(animal);
    }

    @PutMapping
    public void updateAnimal(@RequestBody Animal animal) {
        animalRepo.save(animal);
    }

    @DeleteMapping
    public void deleteAnimal(@RequestParam Long id) {
        animalRepo.deleteById(id);
    }

}
