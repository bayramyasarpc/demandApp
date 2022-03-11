package yte.parttime.demandApp.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.parttime.demandApp.entity.Person;

@RequiredArgsConstructor
@Getter
@ToString
public class AddPersonRequest {


        private String firstName;
        private String lastName;
        private String email;

        public AddPersonRequest(Person person) {
            this.firstName = person.getFirstName();
            this.lastName = person.getLastName();
            this.email = person.getEmail();
        }

        public Person toEntity(){
            return new Person(firstName,lastName,email);
        }
}
