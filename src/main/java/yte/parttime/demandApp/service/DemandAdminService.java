package yte.parttime.demandApp.service;

import lombok.ToString;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import yte.parttime.demandApp.controller.request.UpdateDemandRequest;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.message.MessageType;
import yte.parttime.demandApp.repository.DemandHistoryRepository;
import yte.parttime.demandApp.repository.DemandRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@ToString
public class DemandAdminService {

    private final DemandRepository demandRepository;
    private final DemandHistoryRepository demandHistoryRepository;

    public DemandAdminService(DemandRepository demandRepository, DemandHistoryRepository demandHistoryRepository) {
        this.demandRepository = demandRepository;
        this.demandHistoryRepository = demandHistoryRepository;
    }

    @Transactional
    public MessageResponse updateDemand(Long id, UpdateDemandRequest newDemand) {
        Demand demand = demandRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("demand %s couldn't found".formatted(id)));
        demand.updateDemand(newDemand);
        demandRepository.save(demand);
        return  new MessageResponse("Demadn with id=%s has been updated successfully!".formatted(id), MessageType.SUCCESS);
    }
}
