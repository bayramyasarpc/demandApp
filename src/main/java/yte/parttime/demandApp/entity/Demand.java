package yte.parttime.demandApp.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.sql.Update;
import yte.parttime.demandApp.controller.request.UpdateDemandRequest;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//@MappedSuperclass

@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,name = "demand_type_discriminator ")//
public abstract class Demand{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String demandType;
    private String demandDestination;
    private String status;
    private String message;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "demand_id")
    public Set<DemandHistory> demandHistories=new HashSet<>();




    public Demand(String demandType, String demandDestination,String status,String message) {
        this.demandType = demandType;
        this.demandDestination = demandDestination;
        this.status = status;
        this.message = message;
    }

    public void updateDemand(UpdateDemandRequest updateDemandRequest) {
        this.status=updateDemandRequest.getStatus();
        this.message=updateDemandRequest.getMessage();
    }

    public abstract DemandHistory toHistory();

    public void addHistory(DemandHistory demandHistory) {
        demandHistories.add(demandHistory);
    }
}
