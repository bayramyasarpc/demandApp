package yte.parttime.demandApp.controller.request;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.parttime.demandApp.enums.AuthorityEnum;
import yte.parttime.demandApp.entity.Person;

@Getter
@RequiredArgsConstructor
@ToString
public class AuthorityRequest {
    private String firstName;
    private String lastName;
    private String email;
    private AuthorityEnum authorityEnum;

    public AuthorityRequest(Person person) {
        this.firstName= person.getFirstName();
        this.lastName= person.getLastName();
        this.authorityEnum=getAuthorityEnum();
        this.email=person.getEmail();
    }
}
