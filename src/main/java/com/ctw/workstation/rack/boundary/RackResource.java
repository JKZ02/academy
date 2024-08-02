package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.DataService;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.RackDTO;
import com.ctw.workstation.rack.service.RackRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/racks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RackResource {
    private final DataService dataService = DataService.getInstance();

    @Inject
    RackRepository rackRepository;

    @GET
    public List<Rack> getAllRacks(@QueryParam("status") String status) {
        return rackRepository.getAll();
    }

    @Transactional
    @POST
    public void create(Rack rack) {
        rackRepository.add(rack);
    }

    @Transactional
    @GET
    @Path("/{id}")
    public RackDTO findRack(@PathParam("id") String id) {
        return dataService.findRack(id);
    }

    @Transactional
    @PUT
    @Path("/{id}")
    public Response updateRack(@PathParam("id") String id, RackDTO rackDTO) {
        rackDTO.setId(id);
        dataService.updateRack(rackDTO);
        return Response.ok(rackDTO).status(201).build();
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public Response deleteRack(@PathParam("id") String id) {
        dataService.deleteRack(id);
        return Response.ok().status(200).build();
    }
}
