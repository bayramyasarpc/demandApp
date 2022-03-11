package yte.parttime.demandApp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class DemandHistory{
    @Id
    @GeneratedValue
    private Long id;
    private String demandType;
    private String demandDestination;
    private String status;
    private String message;
    private String password;
    private String zname;
    private Double size;

    public DemandHistory(Long id, String demandType, String demandDestination, String status, String message, String password, String zname, Double size) {
        this.id = id;
        this.demandType = demandType;
        this.demandDestination = demandDestination;
        this.status = status;
        this.message = message;
        this.password = password;
        this.zname = zname;
        this.size = size;
    }
}
