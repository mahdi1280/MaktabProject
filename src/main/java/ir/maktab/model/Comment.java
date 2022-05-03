package ir.maktab.model;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = Schema.SCHEMA_NAME)
public class Comment extends BaseEntity {

    private int score;
    private String details;

    private Offer offer;

    public int getScore() {
        return score;
    }

    public Comment setScore(int score) {
        this.score = score;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Comment setDetails(String details) {
        this.details = details;
        return this;
    }

    @OneToOne
    @MapsId
    public Offer getOffer() {
        return offer;
    }

    public Comment setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }
}
