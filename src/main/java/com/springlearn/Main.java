package com.springlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication //declare it as spring boot application
@RestController
@RequestMapping("api/v1/persons")
public class Main {

    private final PersonRepository personRepository;

    public Main(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

   @GetMapping
    public List<Person> getPerson(){
        return personRepository.findAll();
   }

    record NewPersonRequest(
            String name,
            String email,
            Integer age
    ){

    }
    @PostMapping
   public void addPerson(@RequestBody NewPersonRequest request){
        Person person = new Person();
        person.setName(request.name);
        person.setEmail(request.email);
        person.setAge(request.age);
        personRepository.save(person);
   }
}
