package yte.parttime.demandApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;
import yte.parttime.demandApp.entity.demands.Xdemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.DemandHistoryRepository;
import yte.parttime.demandApp.repository.DemandRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DemandHistoryServiceIT {

    private Long demandID;

    @Autowired
    DemandRepository demandRepository;

    @Autowired
    DemandHistoryRepository demandHistoryRepository;

    @BeforeEach
    void setUp() {
        Demand demand=new Xdemand("xdemand","mentor",null,null,3.1);
        demandRepository.save(demand);
        setDemandID(demand.getId());

        DemandHistoryService demandHistoryService=new DemandHistoryService(demandRepository,demandHistoryRepository);
        demandHistoryService.addLastDemand(demand.getId());
    }

    @Test
    void addLastDemand() {

        DemandHistoryService demandHistoryService=new DemandHistoryService(demandRepository,demandHistoryRepository);
        MessageResponse messageResponse = demandHistoryService.addLastDemand(getDemandID());
        assertThat(messageResponse.getMessage()).isEqualTo("LastDemand added successfully!");
    }

    @Test
    void listDemandHistory() {
        DemandHistoryService demandHistoryService=new DemandHistoryService(demandRepository,demandHistoryRepository);

        List<DemandHistory> demandHistories = demandHistoryService.listDemandHistory(getDemandID());
        assertThat(demandHistories).isNotEmpty();
    }

    public Long getDemandID() {
        return demandID;
    }

    public void setDemandID(Long demandID) {
        this.demandID = demandID;
    }
}