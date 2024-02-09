package io.muehlbachler.fhburgenland.swm.examination.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Represents a person.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private String id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Note> notes;


    /**
     * Returns a string representation of a Person, including the first and last name.
     *
     * @return a string representation of the Person
     */
    @Override
    public String toString() {
        return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName + "]";
    }

    /**
     * Constructor for a new Person with the specified first name, last name, and an auto-generated ID.
     *
     * @param firstName the person's first name
     * @param lastName  the person's last name
     */
    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
