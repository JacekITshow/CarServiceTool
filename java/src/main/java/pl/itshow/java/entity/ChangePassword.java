package pl.itshow.java.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table( name = "change_password")
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

    public ChangePassword() {
    }

    public ChangePassword(Long id, Long userId, String hashcode, Date date) {
        this.id = id;
        this.userId = userId;
        this.hashcode = hashcode;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHashcode() {
        return hashcode;
    }

    public void setHashcode(String hashcode) {
        this.hashcode = hashcode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
