package yte.parttime.demandApp.service;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.message.MessageType;
import yte.parttime.demandApp.repository.DemandHistoryRepository;
import yte.parttime.demandApp.repository.DemandRepository;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;
import java.util.List;

@Service
public class DemandHistoryService {

    private final DemandRepository demandRepository;
    private final DemandHistoryRepository demandHistoryRepository;
    public DemandHistoryService(DemandRepository demandRepository, DemandHistoryRepository demandHistoryRepository) {
        this.demandRepository = demandRepository;
        this.demandHistoryRepository = demandHistoryRepository;
    }

    public MessageResponse addLastDemand(Long id) {
        Demand demand =demandRepository.findById(id).orElseThrow(()->new EntityNotFoundException("not found"));
        DemandHistory demandHistory=demand.toHistory();
        demand.addHistory(demandHistory);
        return new MessageResponse("LastDemand added successfully!", MessageType.SUCCESS);
    }

    public List<DemandHistory> listDemandHistory(Long demandId) {
        return demandHistoryRepository.findByDemandId(demandId);
    }
}
