package yte.parttime.demandApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;

public interface DemandRepository extends JpaRepository<Demand,Long> {
}

