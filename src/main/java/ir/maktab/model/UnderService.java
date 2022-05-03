package ir.maktab.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = Schema.SCHEMA_NAME)
public class UnderService extends BaseEntity {

    private int basePrice;
    private String details;
    private Service service;

    public int getBasePrice() {
        return basePrice;
    }

    public UnderService setBasePrice(int basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public UnderService setDetails(String details) {
        this.details = details;
        return this;
    }

    @ManyToOne
    public Service getService() {
        return service;
    }

    public UnderService setService(Service service) {
        this.service = service;
        return this;
    }
}
