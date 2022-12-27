package pl.wsb.students.intruductionapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director implements Serializable {
    private Integer id;
    private Date created;
    private Date modified;
    private String firstName;
    private String lastName;
    private Date deleted;
    private Set<Movie> movies = new HashSet<>();
    public Director() {
    }
    public Director(Integer id, Date created, Date modified, String firstName,
                    String lastName, Date deleted) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deleted = deleted;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    public Date getCreated() {
        return this.created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", nullable = false, length = 19)
    public Date getModified() {
        return this.modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {this.lastName = lastName;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted", length = 19)
    public Date getDeleted() {
        return deleted;
    }
    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }
    @OneToMany(mappedBy = "director")
    public Set<Movie> getMovies() {
        return movies;
    }
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deleted=" + deleted +
                ", movies=" + movies +
                '}';
    }
}