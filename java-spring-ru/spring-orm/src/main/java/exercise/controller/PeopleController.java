package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
public class PeopleController {

    // Автоматически заполняем значение поля
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return this.personRepository.findById(id);
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PatchMapping("/{id}")
    public Person update(@PathVariable long id, @RequestBody Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        personRepository.deleteById(id);
    }
}
