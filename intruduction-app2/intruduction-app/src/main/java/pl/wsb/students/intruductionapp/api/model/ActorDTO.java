package pl.wsb.students.intruductionapp.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ActorDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("zadanie")
    private String zadanie;
    @JsonProperty("termin")
    private Date termin;

    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("zadanie")
    public String getZadanie() { return zadanie; }
    @JsonProperty("zadanie")
    public void setZadanie(String zadanie) {
        this.zadanie = zadanie;
    }
    @JsonProperty("termin")
    public Date getTermin() {
        return termin;
    }
    @JsonProperty("termin")
    public void setTermin(Date termin) {
        this.termin = termin;
    }
}