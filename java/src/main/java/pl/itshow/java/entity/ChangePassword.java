package pl.itshow.java.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table( name = "change_password")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePassword {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "hashcode")
    private String hashcode;

    @Column(name = "date")
    private Date date;
}
