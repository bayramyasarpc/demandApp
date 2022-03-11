package yte.parttime.demandApp.controller.response;

import lombok.Getter;
import yte.parttime.demandApp.entity.DemandHistory;

@Getter
public class DemandHistoryResponse {
    private Long id;
    private String demandType;
    private String demandDestination;
    private String status;
    private String message;
    private String password;
    private String zname;
    private Double size;

    public DemandHistoryResponse(DemandHistory demandHistory){
        this.id=demandHistory.getId();
        this.demandType=demandHistory.getDemandType();
        this.demandDestination=demandHistory.getDemandDestination();
        this.status=demandHistory.getStatus();
        this.message=demandHistory.getMessage();
        this.password=demandHistory.getPassword();
        this.zname=demandHistory.getZname();
        this.size=demandHistory.getSize();
    }
}
