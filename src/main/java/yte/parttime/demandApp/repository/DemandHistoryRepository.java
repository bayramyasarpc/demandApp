package yte.parttime.demandApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import yte.parttime.demandApp.entity.DemandHistory;

import java.util.List;

public interface DemandHistoryRepository extends JpaRepository<DemandHistory,Long>{

    @Query(value = "select * from demand_history d where d.demand_id=:demandId",nativeQuery = true)
    List<DemandHistory> findByDemandId(Long demandId);
}
