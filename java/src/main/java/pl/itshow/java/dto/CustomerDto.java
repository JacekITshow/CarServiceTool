package pl.itshow.java.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class CustomerDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -5087457987080272447L;

    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private Long phoneNumber;

    private Date birthdate;

    private String description;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String firstName, String lastName, String gender, String email, Long phoneNumber,
                       Date birthdate, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
