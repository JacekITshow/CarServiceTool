package pl.itshow.java.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "service_to_repair")
public class ServiceToRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "repair_id")
    @JsonIgnore
    private Repair repair;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "cost", precision = 10, scale = 2)
    private BigDecimal cost;

    public ServiceToRepair() {
    }

    public ServiceToRepair(Long id, Repair repair, Service service, BigDecimal cost) {
        this.id = id;
        this.repair = repair;
        this.service = service;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
