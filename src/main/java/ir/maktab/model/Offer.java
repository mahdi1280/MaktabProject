package ir.maktab.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(schema = Schema.SCHEMA_NAME)
public class Offer extends BaseEntity{

    private LocalDateTime periodOfTime;
    private int proposedPrice;
    private LocalDateTime createdAt;
    private LocalDateTime startTime;

    private Order order;
    private User user;

    public LocalDateTime getPeriodOfTime() {
        return periodOfTime;
    }

    public Offer setPeriodOfTime(LocalDateTime periodOfTime) {
        this.periodOfTime = periodOfTime;
        return this;
    }

    public int getProposedPrice() {
        return proposedPrice;
    }

    public Offer setProposedPrice(int proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    @CreationTimestamp
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Offer setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Offer setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    @ManyToOne
    public Order getOrder() {
        return order;
    }

    public Offer setOrder(Order order) {
        this.order = order;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Offer setUser(User user) {
        this.user = user;
        return this;
    }
}
