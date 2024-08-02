package com.ctw.workstation.booking.service;

import com.ctw.workstation.booking.entity.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {

    public List<Booking> getAll() {
        return listAll();
    }

    public void addBooking(Booking booking) {
        persist(booking);
    }

}
