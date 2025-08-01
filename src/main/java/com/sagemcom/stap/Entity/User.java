package com.sagemcom.stap.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Size(min = 6)
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(nullable = false)
    private String role = "USER";

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    @CreationTimestamp
    private LocalDateTime createdAt;

    private String name;

    @Lob
    private byte[] image;

    @Column(nullable = false)
    private int badges = 0;

    @Column(nullable = false)
    private int points = 0;

    // 🔗 OneToMany avec Reservation
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("user")
    private List<Reservation> reservations;

    public User() {}

    public User(String email, String password, String role, String name, byte[] image, int badges, int points) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.image = image;
        this.badges = badges;
        this.points = points;
    }

    // Getters et Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }

    public int getBadges() { return badges; }
    public void setBadges(int badges) { this.badges = badges; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public List<Reservation> getReservations() { return reservations; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", email='" + email + '\'' +
               ", role='" + role + '\'' +
               ", name='" + name + '\'' +
               ", badges=" + badges +
               ", points=" + points +
               ", image=" + (image != null ? "[image data]" : "null") +
               '}';
    }
}
