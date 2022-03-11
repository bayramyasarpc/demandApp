package yte.parttime.demandApp.entity.demands;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.parttime.demandApp.entity.Demand;
import yte.parttime.demandApp.entity.DemandHistory;

import javax.persistence.*;

//@Table(name = "demand")
@Entity
@DiscriminatorValue("Xdemand")
public class Xdemand extends Demand{
    private double size;

    public Xdemand() {
    }

    public Xdemand(String demandType, String demandDestination, String status, String message, double size) {
        super(demandType, demandDestination, status, message);
        this.size = size;
    }

    @Override
    public DemandHistory toHistory() {
        return new DemandHistory(null,getDemandType(),getDemandDestination(),getStatus(),getMessage(),null,null,size);
    }
}
