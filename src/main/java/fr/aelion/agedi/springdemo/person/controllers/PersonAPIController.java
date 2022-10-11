package fr.aelion.agedi.springdemo.person.controllers;

import fr.aelion.agedi.springdemo.person.entities.Person;
import fr.aelion.agedi.springdemo.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonAPIController {

    @Autowired
    PersonService personSrv;

    /**
     * Use ResponseEntity
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Iterable<Person>> index() {
        return new ResponseEntity<>(this.personSrv.findAll(), HttpStatus.OK);
    }

    /**
     * TODO finalize implementation  with Optional
     * @param id
     * @return
     */
    @GetMapping("")
    public Person get(@PathVariable("id") Long id) {
        // orElseThrow , etc..
        return this.personSrv.findById(id).get();
    }
}
