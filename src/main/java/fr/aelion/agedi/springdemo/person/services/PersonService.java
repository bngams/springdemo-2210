package fr.aelion.agedi.springdemo.person.services;

import fr.aelion.agedi.springdemo.exceptions.BadContentException;
import fr.aelion.agedi.springdemo.exceptions.EntityNotFoundException;
import fr.aelion.agedi.springdemo.person.entities.Person;
import fr.aelion.agedi.springdemo.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepo;

    public Iterable<Person> findAll() {
        // data customization
        // this.personRepo.findAll().forEach(...)
        // Stream...
        // data storage / cache
        // this.people = this.personRepo.findAll();
        return this.personRepo.findAll();
    }

    public Person findById(Long id) throws BadContentException, EntityNotFoundException {
        this.validateIdOrThrowsBadContentException(id);
        // java optional
        return this.personRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void validateIdOrThrowsBadContentException(Long id) throws BadContentException {
        if(id < 10) {
            throw new BadContentException();
        }
    }


}
