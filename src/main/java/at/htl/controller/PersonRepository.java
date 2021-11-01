package at.htl.controller;

import at.htl.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.Instant;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    @Transactional
    public void add(String firstName, String lastName, String email, String phoneNumber) {
        persist(new Person(
                firstName,
                lastName,
                email,
                phoneNumber,
                Instant.now()
        ));
    }
}
