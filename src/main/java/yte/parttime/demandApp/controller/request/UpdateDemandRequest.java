package yte.parttime.demandApp.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.sql.Update;

@Getter
@ToString
@RequiredArgsConstructor
public class UpdateDemandRequest {

    private final String status;
    private final String message;

    public UpdateDemandRequest updateDemand(){
        return new UpdateDemandRequest(status,message);
    }
}
