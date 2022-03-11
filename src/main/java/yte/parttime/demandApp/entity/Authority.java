package yte.parttime.demandApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import yte.parttime.demandApp.entity.Users;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

    @ManyToMany(mappedBy ="authorities")
    private Set<Users> users;
}
