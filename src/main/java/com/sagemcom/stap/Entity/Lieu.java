package com.sagemcom.stap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lieux")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String adresse;

    @Lob
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("lieux")
    private Category category;

    @OneToMany(mappedBy = "lieu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("lieu")
    private List<Event> events;

    // 🔗 OneToMany avec Reservation
    @OneToMany(mappedBy = "lieu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("lieu")
    private List<Reservation> reservations;

    public Lieu() {}

    public Lieu(String nom, String adresse, byte[] image, Category category) {
        this.nom = nom;
        this.adresse = adresse;
        this.image = image;
        this.category = category;
    }

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public List<Event> getEvents() { return events; }
    public void setEvents(List<Event> events) { this.events = events; }

    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }
}
