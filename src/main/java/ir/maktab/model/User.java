package ir.maktab.model;

import ir.maktab.model.enums.Role;
import ir.maktab.model.enums.UserStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = Schema.USER_TABLE_NAME,schema = Schema.SCHEMA_NAME)
public class User extends BaseEntity {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean deleted = false;
    private byte[] image;
    private LocalDateTime createdAt;
    private int credit;
    private UserStatus status;
    private Role role;
    private Collection<Service> services=new ArrayList<>();

    public User(String firstname, String lastname, String email, String password, byte[] image, int credit, UserStatus status, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.image = image;
        this.credit = credit;
        this.status = status;
        this.role = role;
    }

    public User() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_service",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    public Collection<Service> getServices() {
        return services;
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @CreationTimestamp
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Enumerated(EnumType.STRING)
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static class Builder{

        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private byte[] image;
        private int credit;
        private UserStatus status;
        private Role role;

        private Builder(){}

        public Builder firstname(String firstname){
            this.firstname=firstname;
            return this;
        }

        public Builder lastname(String lastname){
            this.lastname=lastname;
            return this;
        }

        public Builder email(String email){
            this.email=email;
            return this;
        }

        public Builder password(String password){
            this.password=password;
            return this;
        }

        public Builder image(byte[] image){
            this.image=image;
            return this;
        }

        public Builder credit(int credit){
            this.credit=credit;
            return this;
        }

        public Builder status(UserStatus status){
            this.status=status;
            return this;
        }

        public Builder role(Role role){
            this.role=role;
            return this;
        }

        public User build(){
            return new User(firstname, lastname, email, password, image, credit, status, role);
        }

    }
}
