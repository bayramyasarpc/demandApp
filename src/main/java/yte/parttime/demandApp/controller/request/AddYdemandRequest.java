package yte.parttime.demandApp.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.parttime.demandApp.entity.demands.Ydemand;

@Getter
@RequiredArgsConstructor
@ToString
public class AddYdemandRequest {
    private final String demandType;
    private final String demandDestination;
    private final String status;
    private final String message;
    private final String password;

    public Ydemand toEntity(){
        return new Ydemand(demandType,demandDestination,message,status,password);
    }
}
