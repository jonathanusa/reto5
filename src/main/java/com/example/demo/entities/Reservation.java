package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@JsonPropertyOrder({"idReservation", "startDate","devolutionDate", "status", "boat", "client", "score"})
@Table(name = "reservation")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    
    @ManyToOne
    @JoinColumn(name = "clientID")
    @JsonIgnoreProperties({"reservations","messages"}) // Se ignora el atributo reservations en clase Client para evitar ciclo infinito
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "boatID")
    @JsonIgnoreProperties("reservations") // Se ignora el atributo reservations en clase Boat para evitar ciclo infinito
    private Boat boat;
    
    @ManyToOne
    @JoinColumn(name = "scoreID")
    @JsonIgnoreProperties("reservations") // Se ignora el atributo reservation en clase Score para evitar ciclo infinito
    private Score score;
    
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
    
    
}
