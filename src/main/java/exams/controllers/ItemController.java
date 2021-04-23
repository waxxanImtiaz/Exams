package exams.controllers;

import exams.beans.Person;
import exams.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ItemController {

    @Autowired
    private PersonService personService;
    @Autowired
    private WebClient.Builder webClient;
//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping(produces = "application/json",value = "/test")
    public String hello() {
        return "Hello i am server";
    }

    @RequestMapping(produces = "application/json",value = "/save")
    public List<Person> save() {
        List<Person> personList = Arrays.asList(new Person("Imtiaz", "Karachi"),
                new Person("Asim", "Lahore"));
        return personService.savePersons(personList);
    }
    @RequestMapping(produces = "application/json",value = "/exam")
    public List<Person> start(){
        List<Person> personList = Arrays.asList(new Person("Imtiaz","Karachi"),
                new Person("Asim","Lahore"));
        return personList;
//
//        return personList.stream().map(person -> {
//            return webClient.build().get().uri("http://localhost:8115/sports/"+person.getName()).retrieve().bodyToMono(Person.class).block();
//
//        }).collect(Collectors.toList());
//        return restTemplate.getForObject(,Person.class);
        //return "This is exams service";
    }
}
