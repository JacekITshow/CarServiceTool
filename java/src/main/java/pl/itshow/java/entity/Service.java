package pl.itshow.java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "service")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "recommended_cost", precision = 10, scale = 2)
    private BigDecimal recommendedCost;

    @Column(name = "min_cost", precision = 10, scale = 2)
    private BigDecimal minCost;

    @Column(name = "max_cost", precision = 10, scale = 2)
    private BigDecimal maxCost;

    @Column(name = "description")
    private String description;
}
