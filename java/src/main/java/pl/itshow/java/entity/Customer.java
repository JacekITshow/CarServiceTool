package pl.itshow.java.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table( name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "surname")
    String surname;

    @Column(name = "gender")
    String gender;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    Long phoneNumber;

    @Column(name = "birthdate")
    Date birthdate;

    @Column(name = "description")
    String description;

    public Customer() {

    }

    public Customer(Long id, String firstName, String surname, String gender, String email, Long phoneNumber, Date birthdate, String description) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", birthDate=" + birthdate +
                ", description='" + description + '\'' +
                '}';
    }
}
