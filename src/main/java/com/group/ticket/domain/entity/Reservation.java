package com.group.ticket.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "reservation")
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "seats", nullable = false)
    private String selectedSeats;

    public String[] getSeatsArray() {
        if (selectedSeats == null || selectedSeats.isEmpty()) {
            return new String[]{};
        }
        return selectedSeats.split(",");
    }
    public void setSeatsArray(String[] seatsArray) {
        this.selectedSeats= String.join(",", seatsArray);
    }

    @Column(nullable = false)
    private Long sid;

    @Column(nullable = false)
    private Long price;
}
