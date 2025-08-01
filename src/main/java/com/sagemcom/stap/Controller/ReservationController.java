package com.sagemcom.stap.Controller;

import com.sagemcom.stap.Entity.Reservation;
import com.sagemcom.stap.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAll() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getByUser(@PathVariable Long userId) {
        return reservationService.getReservationsByUser(userId);
    }

    @GetMapping("/lieu/{lieuId}")
    public List<Reservation> getByLieu(@PathVariable Long lieuId) {
        return reservationService.getReservationsByLieu(lieuId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
