package yte.parttime.demandApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.parttime.demandApp.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
}
