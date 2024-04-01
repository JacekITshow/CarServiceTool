package pl.itshow.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}
