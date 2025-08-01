package com.sagemcom.stap.Service;

import com.sagemcom.stap.Entity.Reservation;
import com.sagemcom.stap.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> getReservationsByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    public List<Reservation> getReservationsByLieu(Long lieuId) {
        return reservationRepository.findByLieuId(lieuId);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
