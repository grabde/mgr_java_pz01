package pl.wsb.students.intruductionapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
public class Movie implements java.io.Serializable {
    private Integer id;
    private Date created;
    private Date modified;
    private String title;
    private String releaseYear;
    private Date deleted;

    private Director director;
    public Movie() {
    }
    public Movie(Integer id, Date created, Date modified, String title, String
            releaseYear, Date deleted) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.title = title;
        this.releaseYear = releaseYear;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Column(name = "release_year")
    public String getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted", length = 19)
    public Date getDeleted() {
        return deleted;
    }
    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    @ManyToOne
    @JoinColumn(name = "director_id")
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", created=" + created +
                ", modified=" + modified +
                ", title='" + title + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", deleted=" + deleted +
                '}';
    }

}