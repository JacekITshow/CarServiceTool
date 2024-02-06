package pl.itshow.java.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "plate")
    private String plane;

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

    public Car() {
    }

    public Car(Long id, Long customerId, String plane, String plateCountry, String vin, String brand, String model, String modelCode) {
        this.id = id;
        this.customerId = customerId;
        this.plane = plane;
        this.plateCountry = plateCountry;
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.modelCode = modelCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getPlateCountry() {
        return plateCountry;
    }

    public void setPlateCountry(String plateCountry) {
        this.plateCountry = plateCountry;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }
}
