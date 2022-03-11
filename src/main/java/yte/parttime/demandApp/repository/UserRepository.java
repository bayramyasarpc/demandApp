package yte.parttime.demandApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.parttime.demandApp.entity.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
}
