package yte.parttime.demandApp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yte.parttime.demandApp.controller.request.*;
import yte.parttime.demandApp.controller.response.DemandHistoryResponse;
import yte.parttime.demandApp.message.MessageResponse;
import yte.parttime.demandApp.service.DemandAdminService;
import yte.parttime.demandApp.service.DemandHistoryService;
import yte.parttime.demandApp.service.DemandService;

import java.util.List;

@RestController
public class DemandController {

    private final DemandService demandService;

    private final DemandHistoryService demandHistoryService;

    public DemandController(DemandService demandService, DemandHistoryService demandHistoryService) {
        this.demandService = demandService;

        this.demandHistoryService = demandHistoryService;
    }

    @PostMapping("/x-talep-ekle/{id}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public MessageResponse addXdemand(@PathVariable Long id,@RequestBody AddXdemandRequest addXdemandRequest){
        return demandService.addXdemand(id,addXdemandRequest.toEntity());
    }

    @PostMapping("/y-talep-ekle/{id}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public MessageResponse addYdemand(@PathVariable Long id,@RequestBody AddYdemandRequest addYdemandRequest){
        return demandService.addYdemand(id,addYdemandRequest.toEntity());
    }
    @PostMapping("/z-talep-ekle/{id}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public MessageResponse addZdemand(@PathVariable Long id,@RequestBody AddZdemadnRequest addZdemandRequest){
        return demandService.addZdemand(id,addZdemandRequest.toEntity());
    }

    @GetMapping("/talep-listele/{demandId}")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public List<DemandHistoryResponse> listDemandHistory(@PathVariable Long demandId){
        return demandHistoryService.listDemandHistory(demandId)
                .stream()
                .map(demandHistory -> new DemandHistoryResponse(demandHistory))
                .toList();
    }
}
