package yte.parttime.demandApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import yte.parttime.demandApp.entity.Users;
import yte.parttime.demandApp.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceIT {
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        Users users=new Users(1L,"bayram","yasar",null,null);
        userRepository.save(users);
    }

    @Test
    void loadUserByUsername() {
        UserService userService=new UserService(userRepository);

        UserDetails userDetails = userService.loadUserByUsername("bayram");

        assertThat(userDetails.getUsername()).isEqualTo("bayram");

    }
}