package exams.service;

import exams.beans.Person;
import exams.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService  {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> savePersons(List<Person> persons){
//        Iterable<Person> people = persons.subList(0,persons.size());
        return personRepository.saveAll(persons);
    }
}
