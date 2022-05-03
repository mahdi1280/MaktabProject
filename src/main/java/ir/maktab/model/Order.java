package ir.maktab.model;

import ir.maktab.model.enums.StatusOrder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = Schema.SCHEMA_NAME)
public class Order extends BaseEntity{

    private int proposedPrice;
    private LocalDateTime createdAt;
    private String address;
    private StatusOrder status;
    private LocalDateTime wordTime;

    private UnderService underService;
    private User user;

    public int getProposedPrice() {
        return proposedPrice;
    }

    public Order setProposedPrice(int proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    @CreationTimestamp
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Order setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public StatusOrder getStatus() {
        return status;
    }

    public Order setStatus(StatusOrder status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getWordTime() {
        return wordTime;
    }

    public Order setWordTime(LocalDateTime wordTime) {
        this.wordTime = wordTime;
        return this;
    }

    @ManyToOne
    public UnderService getUnderService() {
        return underService;
    }

    public Order setUnderService(UnderService underService) {
        this.underService = underService;
        return this;
    }


    @ManyToOne
    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }
}
