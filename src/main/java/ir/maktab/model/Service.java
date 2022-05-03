package ir.maktab.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = Schema.SCHEMA_NAME)
public class Service extends BaseEntity {

    private String title;

    public String getTitle() {
        return title;
    }

    public Service setTitle(String title) {
        this.title = title;
        return this;
    }
}
