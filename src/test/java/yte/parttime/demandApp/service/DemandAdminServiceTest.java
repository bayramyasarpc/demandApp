package yte.parttime.demandApp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import yte.parttime.demandApp.controller.request.UpdateDemandRequest;
import yte.parttime.demandApp.entity.demands.Xdemand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.repository.DemandRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@MockitoSettings(strictness = Strictness.LENIENT)
class DemandAdminServiceTest {

    @InjectMocks
    DemandAdminService demandAdminService;

    @Mock
    DemandRepository demandRepository;

    @Test
    void updateDemandFoundDemand() {
        Xdemand xdemand=new Xdemand();
        UpdateDemandRequest updateDemandRequest=new UpdateDemandRequest("waiting","it is too long");
        when(demandRepository.findById(any())).thenReturn(Optional.of(xdemand));

        MessageResponse messageResponse = demandAdminService.updateDemand(1L, updateDemandRequest);

        assertThat(messageResponse.getMessage()).isEqualTo("Demadn with id=%s has been updated successfully!".formatted(1));
    }

    @Test
    void updateDemandNotFoundDemand() {
        UpdateDemandRequest updateDemandRequest=new UpdateDemandRequest("waiting","it is too long");
        when(demandRepository.findById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(()->demandAdminService.updateDemand(1L,updateDemandRequest))
                .isInstanceOf(EntityNotFoundException.class).hasMessage("demand %s couldn't found".formatted(1L));
    }
}