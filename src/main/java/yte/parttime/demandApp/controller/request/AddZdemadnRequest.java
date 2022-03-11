package yte.parttime.demandApp.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.parttime.demandApp.entity.demands.Zdemand;

@Getter
@RequiredArgsConstructor
@ToString
public class AddZdemadnRequest{
    private final String demandType;
    private final String demandDestination;
    private final String status;
    private final String message;
    private final String zname;

    public Zdemand toEntity(){
        return new Zdemand(demandType,demandDestination,status,message,zname);
    }
}
