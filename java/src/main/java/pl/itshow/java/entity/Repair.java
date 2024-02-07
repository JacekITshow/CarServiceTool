package pl.itshow.java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "repair")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "car_id")
    private Long carId;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "admission_date")
    private Date admissionDate;

    @Column(name = "estimated_date")
    private Date estimatedDate;

    @Column(name = "description")
    private String description;


    @OneToMany(fetch = FetchType.EAGER, mappedBy="repair")
    private Set<ServiceToRepair> serviceToRepairs;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="repair")
    private Set<Part> parts;
}
