package pl.itshow.java.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "car")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "plate")
    private String plate;

    @Column(name = "plate_country")
    private String plateCountry;

    @Column(name = "vin")
    private String vin;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "model_code")
    private String modelCode;
}
