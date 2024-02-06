package pl.itshow.java.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "service")
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

    public Service() {
    }

    public Service(Long id, String name, BigDecimal recommendedCost, BigDecimal minCost, BigDecimal maxCost, String description) {
        this.id = id;
        this.name = name;
        this.recommendedCost = recommendedCost;
        this.minCost = minCost;
        this.maxCost = maxCost;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRecommendedCost() {
        return recommendedCost;
    }

    public void setRecommendedCost(BigDecimal recommendedCost) {
        this.recommendedCost = recommendedCost;
    }

    public BigDecimal getMinCost() {
        return minCost;
    }

    public void setMinCost(BigDecimal minCost) {
        this.minCost = minCost;
    }

    public BigDecimal getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(BigDecimal maxCost) {
        this.maxCost = maxCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
