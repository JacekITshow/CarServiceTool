package pl.itshow.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String gender;

    private String email;

    private Long phoneNumber;

    private Date birthdate;

    private String description;

}
