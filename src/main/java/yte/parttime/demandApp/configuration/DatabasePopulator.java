package yte.parttime.demandApp.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import yte.parttime.demandApp.entity.Authority;
import yte.parttime.demandApp.repository.AuthorityRepository;
import yte.parttime.demandApp.repository.UserRepository;
import yte.parttime.demandApp.entity.Users;

import javax.transaction.Transactional;
import java.util.Set;


@Repository
public class DatabasePopulator {

    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabasePopulator(AuthorityRepository authorityRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void populateDatabase(){

        Authority userAuthority = authorityRepository.save(new Authority(1L, "USER", Set.of()));
        Authority adminAuthority = authorityRepository.save(new Authority(2L, "ADMIN", Set.of()));

        Users users =new Users(1L,"user",passwordEncoder.encode("user"),Set.of(userAuthority),null);
        userRepository.save(users);

        Users admin =new Users(2L,"admin",passwordEncoder.encode("admin"),Set.of(adminAuthority,userAuthority),null);
        userRepository.save(admin);
    }
}
