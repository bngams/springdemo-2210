package fr.aelion.agedi.springdemo.person.controllers;

import fr.aelion.agedi.springdemo.exceptions.ApiError;
import fr.aelion.agedi.springdemo.exceptions.BadContentException;
import fr.aelion.agedi.springdemo.exceptions.EntityNotFoundException;
import fr.aelion.agedi.springdemo.exceptions.GlobalException;
import fr.aelion.agedi.springdemo.person.entities.Person;
import fr.aelion.agedi.springdemo.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    // required = false => SIMULATION
    public Person get(@PathVariable(value = "id") Long id)
            throws BadContentException, EntityNotFoundException {
        // orElseThrow , etc.
        return this.personSrv.findById(id);
    }

}
