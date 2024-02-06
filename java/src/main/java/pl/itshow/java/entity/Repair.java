package pl.itshow.java.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "repair")
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

    public Repair() {
    }

    public Repair(Long id, Long carId, Long mileage, Date admissionDate, Date estimatedDate, String description, Set<ServiceToRepair> serviceToRepairs, Set<Part> parts) {
        this.id = id;
        this.carId = carId;
        this.mileage = mileage;
        this.admissionDate = admissionDate;
        this.estimatedDate = estimatedDate;
        this.description = description;
        this.serviceToRepairs = serviceToRepairs;
        this.parts = parts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getEstimatedDate() {
        return estimatedDate;
    }

    public void setEstimatedDate(Date estimatedDate) {
        this.estimatedDate = estimatedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ServiceToRepair> getServiceToRepairs() {
        return serviceToRepairs;
    }

    public void setServiceToRepairs(Set<ServiceToRepair> serviceToRepairs) {
        this.serviceToRepairs = serviceToRepairs;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
