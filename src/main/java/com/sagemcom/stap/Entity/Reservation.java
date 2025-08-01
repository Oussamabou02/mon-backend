package com.sagemcom.stap.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime heure;

    @Column(nullable = false)
    private int nombrePersonnes;

    // 🔗 ManyToOne avec Lieu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lieu_id")
    @JsonIgnoreProperties({"events", "category", "reservations", "hibernateLazyInitializer", "handler"})
    private Lieu lieu;

    // 🔗 ManyToOne avec User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"password", "image", "reservations", "hibernateLazyInitializer", "handler"})
    private User user;

    public Reservation() {}

    public Reservation(LocalDate date, LocalTime heure, int nombrePersonnes, Lieu lieu, User user) {
        this.date = date;
        this.heure = heure;
        this.nombrePersonnes = nombrePersonnes;
        this.lieu = lieu;
        this.user = user;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public int getNombrePersonnes() { return nombrePersonnes; }
    public void setNombrePersonnes(int nombrePersonnes) { this.nombrePersonnes = nombrePersonnes; }

    public Lieu getLieu() { return lieu; }
    public void setLieu(Lieu lieu) { this.lieu = lieu; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
