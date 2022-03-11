package yte.parttime.demandApp.entity.demands;

import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

//Table(name = "demand")
@Entity
@DiscriminatorValue("Zdemand")
public class Zdemand extends Demand {
    private String zname;

    public Zdemand() {
    }

    public Zdemand(String demandType, String demandDestination, String status, String message, String zname) {
        super(demandType, demandDestination, status, message);
        this.zname = zname;
    }

    @Override
    public DemandHistory toHistory() {
        return new DemandHistory(null,getDemandType(),getDemandDestination(),getStatus(),getMessage(),null,zname,null);
    }
}
