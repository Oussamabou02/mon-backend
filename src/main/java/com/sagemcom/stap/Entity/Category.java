package com.sagemcom.stap.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  // <-- IMPORTANT
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Column(name = "image")
    private byte[] image;

    // Relation OneToMany vers Lieu
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("category")  // Ignore la propriété category dans Lieu (évite boucle)
    private List<Lieu> lieux;

    // Constructeurs
    public Category() {}

    public Category(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public byte[] getImage() { return image; }
    public void setImage(byte [] image) { this.image = image; }

    public List<Lieu> getLieux() { return lieux; }
    public void setLieux(List<Lieu> lieux) { this.lieux = lieux; }
}
