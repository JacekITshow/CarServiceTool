package pl.itshow.java.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "service_to_repair")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
