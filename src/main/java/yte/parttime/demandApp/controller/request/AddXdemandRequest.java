package yte.parttime.demandApp.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.parttime.demandApp.entity.demands.Xdemand;

@RequiredArgsConstructor
@Getter
@ToString
public class AddXdemandRequest {
    private final String demandType;
    private final String demandDestination;
    private final String status;
    private final String message;
    private final double size;

    public Xdemand toEntity(){
        return new Xdemand(demandType,demandDestination,status,message,size);
    }
}
