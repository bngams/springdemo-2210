package fr.aelion.agedi.springdemo.person.services;

import fr.aelion.agedi.springdemo.exceptions.BadContentException;
import fr.aelion.agedi.springdemo.exceptions.EntityNotFoundException;
import fr.aelion.agedi.springdemo.person.entities.Person;
import fr.aelion.agedi.springdemo.person.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    // @Mock != @MockBean
    // @Mock vanilla Mockito;
    // @MockBean => inject in Spring Context (=> allow @Autowired)
    @Mock
    PersonRepository personRepo;
    private PersonService personSrv;

    @BeforeEach
    public void init() {
        this.personSrv = new PersonService();
        this.personSrv.personRepo = this.personRepo; // can access protected attribute
        // this.personSrv = new PersonService(this.personRepo); // if DI was in constructor
    }

    @Test
    public void findById() throws BadContentException, EntityNotFoundException {
        // hardcoded repository result
        Person pMock = new Person(101L, "Boris");
        // simulate personRepo.findById
        when(this.personRepo.findById(101L)).thenReturn(Optional.of(pMock));
        Person p = this.personSrv.findById(101L);
        assertEquals(pMock, p);
    }

    @Test
    public void findByIdShouldTriggerBadContentExceptionWhenIdLt100() {
        assertThrows(BadContentException.class, () -> {
            this.personSrv.findById(1L);
        });
    }

    @Test
    public void validateIdOrThrowsBadContentException() {
        assertThrows(BadContentException.class, () -> {
            this.personSrv.validateIdOrThrowsBadContentException(9L);
        });
    }
}
