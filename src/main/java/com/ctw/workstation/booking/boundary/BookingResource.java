package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.DataService;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.entity.BookingDTO;
import com.ctw.workstation.booking.service.BookingRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/bookings")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookingResource {
    private final DataService dataService = DataService.getInstance();

    @Inject
    BookingRepository bookingRepository;

    @GET
    public List<Booking> getAllBookings() {
        return bookingRepository.getAll();
        //return dataService.getAllBookings();
    }

    @POST
    public Response create(BookingDTO bookingDTO) {
        dataService.createBooking(bookingDTO);
        return Response.ok(bookingDTO).status(201).build();
    }

    @GET
    @Path("/{id}")
    public BookingDTO findBooking(@PathParam("id") String id) {
        return dataService.findBooking(id);
    }
    @PUT
    @Path("/{id}")
    public Response updateBooking(@PathParam("id") String id, BookingDTO bookingDTO) {
        bookingDTO.setId(id);
        dataService.updateBooking(bookingDTO);
        return Response.ok(bookingDTO).status(201).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBooking(@PathParam("id") String id) {
        dataService.deleteBooking(id);
        return Response.ok().status(200).build();
    }
}