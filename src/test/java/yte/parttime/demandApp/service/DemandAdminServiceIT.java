package yte.parttime.demandApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import yte.parttime.demandApp.controller.request.UpdateDemandRequest;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.demands.Xdemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.DemandHistoryRepository;
import yte.parttime.demandApp.repository.DemandRepository;
import yte.parttime.demandApp.repository.PersonRepository;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class DemandAdminServiceIT {

    @Autowired
    DemandRepository demandRepository;
    DemandHistoryRepository demandHistoryRepository;

    @BeforeEach
    void setUp() {
        Demand demand=new Xdemand("xdemand","mentor",null,null,3.1);
        demandRepository.save(demand);
    }

    @Test
    void updateDemand(){
        UpdateDemandRequest newDemand=new UpdateDemandRequest("in progress","it takes 5 days");
        DemandAdminService demandAdminService=new DemandAdminService(demandRepository,demandHistoryRepository);

        MessageResponse messageResponse = demandAdminService.updateDemand(1L, newDemand);

        assertThat(messageResponse.getMessage()).isEqualTo("Demadn with id=1 has been updated successfully!");

    }
}
