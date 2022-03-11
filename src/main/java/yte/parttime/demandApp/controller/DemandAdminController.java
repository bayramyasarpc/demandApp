package yte.parttime.demandApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.parttime.demandApp.controller.request.UpdateDemandRequest;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.service.DemandAdminService;
import yte.parttime.demandApp.service.DemandHistoryService;

@RestController
public class DemandAdminController {

    private final DemandAdminService demandAdminService;
    private final DemandHistoryService demandHistoryService;

    public DemandAdminController(DemandAdminService demandAdminService, DemandHistoryService demandHistoryService) {
        this.demandAdminService = demandAdminService;
        this.demandHistoryService = demandHistoryService;
    }


    @PutMapping("/talep-guncelle/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public MessageResponse updateDemand(@PathVariable Long id, @RequestBody UpdateDemandRequest updateDemandRequest){
        demandHistoryService.addLastDemand(id);
        return demandAdminService.updateDemand(id,updateDemandRequest.updateDemand());
    }
}
