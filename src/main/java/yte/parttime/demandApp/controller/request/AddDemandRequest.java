package yte.parttime.demandApp.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;

@RequiredArgsConstructor
@Getter
@ToString
public class AddDemandRequest {
    private final String demandType;
    private final String demandDestination;
    private final String status;
    private final String message;

    public Demand toEntity(){
        return new Demand(demandType, demandDestination, status, message) {
            @Override
            public DemandHistory toHistory() {
                return null;
            }
        };
    }
}
