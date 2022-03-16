package yte.parttime.demandApp.entity;

import lombok.*;
import org.apache.catalina.User;
import yte.parttime.demandApp.entity.demands.Xdemand;
import yte.parttime.demandApp.entity.demands.Ydemand;
import yte.parttime.demandApp.entity.demands.Zdemand;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="person_id")
    private Set<Demand> demands =new HashSet<>();

    @OneToOne(mappedBy = "person")
    private Users users;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addYdemand(Ydemand ydemand) {
        demands.add(ydemand);
    }

    public void addZdemand(Zdemand zdemand) {
        demands.add(zdemand);
    }

    public void addXdemand(Xdemand xdemand) {
        demands.add(xdemand);
    }


    public void addUser(Person person) {

    }
}
