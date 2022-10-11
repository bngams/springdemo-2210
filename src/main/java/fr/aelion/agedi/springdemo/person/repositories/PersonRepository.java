package fr.aelion.agedi.springdemo.person.repositories;

import fr.aelion.agedi.springdemo.person.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Spring Data Repository
// @Component
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    // add methods
    // query method
    List<Person> findByName(String name);

    // @Query, with native SQL query
    @Query(nativeQuery = true, value = "SELECT * FROM PERSON")
    List<Person> anyMethodName();
}
