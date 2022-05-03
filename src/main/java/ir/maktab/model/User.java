package ir.maktab.model;

import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.UserStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = Schema.USER_TABLE_NAME,schema = Schema.SCHEMA_NAME)
public class User extends BaseEntity {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String specialty;
    private boolean deleted = false;
    private byte[] image;
    private LocalDateTime createdAt;
    private int credit;
    private UserStatus status;
    private Role role;

    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSpecialty() {
        return specialty;
    }

    public User setSpecialty(String specialty) {
        this.specialty = specialty;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public User setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public User setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public int getCredit() {
        return credit;
    }

    public User setCredit(int credit) {
        this.credit = credit;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public UserStatus getStatus() {
        return status;
    }

    public User setStatus(UserStatus status) {
        this.status = status;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }
}
