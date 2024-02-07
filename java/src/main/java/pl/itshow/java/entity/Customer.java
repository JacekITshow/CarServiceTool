package pl.itshow.java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "customer")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

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
}
