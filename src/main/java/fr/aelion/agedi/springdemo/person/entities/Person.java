package fr.aelion.agedi.springdemo.person.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

// JPA
@Entity
// => Java/Entity Bean (default constructor / all args / getters / setters)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // JSON serialization with jackson
    @JsonProperty("lastname")
    // validation constraints (hibernate validators)
    @NotNull
    @Min(3)
    // JPA column
    @Column(name="NAME")
    private String name;
}
