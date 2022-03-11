package yte.parttime.demandApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;
import yte.parttime.demandApp.entity.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query(value ="select * from person p where p.first_name=:firstName AND p.last_name=:lastName",nativeQuery = true)
    Person findByFirstnameAndLastname(String firstName, String lastName);
}
