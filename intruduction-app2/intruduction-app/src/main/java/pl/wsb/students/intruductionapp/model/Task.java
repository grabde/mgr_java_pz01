package pl.wsb.students.intruductionapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    private Integer id;
    private Date created;
    private Date modified;
    private String zadanie;
    private String termin;

    public Task() {
    }
    public Task(Integer id, Date created, Date modified, String zadanie, String termin ) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.zadanie = zadanie;
        this.termin = termin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", length = 19, nullable = false)
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Column(name = "zadanie")
    public String getZadanie() {
        return zadanie;
    }

    public void setZadanie(String zadanie) {
        this.zadanie = zadanie;
    }


    @Column(name = "termin", length = 10, nullable = false)
    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }
}
