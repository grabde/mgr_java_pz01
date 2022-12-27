package pl.wsb.students.intruductionapp.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class MovieDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    @NotEmpty(message = "Proszę uzupełnić tytuł filmu.")
    private String title;
    @JsonProperty("releaseYear")
    @NotEmpty(message = "Proszę uzupełnić rok wydania filmu.")
    private String releaseYear;

    @JsonProperty("directorFirstName")
    private String directorFirstName;
    @JsonProperty("directorLastName")
    private String directorLastName;
    @JsonProperty("directorId")
    private Integer directorId;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getDirectorFirstName() {
        return directorFirstName;
    }
    public void setDirectorFirstName(String directorFirstName) {
        this.directorFirstName = directorFirstName;
    }
    public String getDirectorLastName() {
        return directorLastName;
    }
    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }
    public Integer getDirectorId() {
        return directorId;
    }
    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }
}