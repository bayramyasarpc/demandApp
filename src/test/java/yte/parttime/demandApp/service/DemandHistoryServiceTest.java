package yte.parttime.demandApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.mock.mockito.MockBean;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;
import yte.parttime.demandApp.entity.demands.Zdemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.DemandHistoryRepository;
import yte.parttime.demandApp.repository.DemandRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DemandHistoryServiceTest {

    @Mock
    DemandRepository demandRepository;
    @Mock
    DemandHistoryRepository demandHistoryRepository;

    @InjectMocks
    DemandHistoryService demandHistoryService;


    @Test
    void addLastDemand() {
        Zdemand zdemand=new Zdemand();

        when(demandRepository.findById(1L)).thenReturn(Optional.of(zdemand));

        MessageResponse messageResponse = demandHistoryService.addLastDemand(1L);

        assertThat(messageResponse.getMessage()).isEqualTo("LastDemand added successfully!");

    }
    @Test
    void addLastDemandNotFoundDemand() {
        when(demandRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(()->demandHistoryService.addLastDemand(1L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("not found");
    }

}