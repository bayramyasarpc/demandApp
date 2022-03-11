package yte.parttime.demandApp.entity.demands;

import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Table(name = "demand")
@Entity
@DiscriminatorValue("Ydemand")
public class Ydemand extends  Demand{
    private String password;


    public Ydemand() {
    }

    public Ydemand(String demandType, String demandDestination, String status, String message, String password) {
        super(demandType, demandDestination, status, message);
        this.password = password;
    }

    @Override
    public DemandHistory toHistory() {
        return new DemandHistory(null,getDemandType(),getDemandDestination(),getStatus(),getMessage(),password,null,null);
    }
}
