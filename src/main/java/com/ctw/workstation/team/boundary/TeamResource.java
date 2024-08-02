package com.ctw.workstation.team.boundary;

import com.ctw.workstation.DataService;
import com.ctw.workstation.ExternalApi;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.service.TeamRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/teams")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    private final DataService dataService = DataService.getInstance();

    Logger logger = Logger.getLogger(TeamResource.class);

    @Inject
    TeamRepository teamRepository;

    @Transactional
    @GET
    public List<TeamDTO> getAllTeams() {
        logger.info("Fetching all teams");
        return teamRepository.getAll();
    }

    @GET
    @Path("/{name}")
    public Team findTeam(@PathParam("name") String name) {
        //externalApi.hello();
        return teamRepository.findByName(name);
    }
    @Transactional
    @PUT
    @Path("/{name}")
    public Response updateTeam(@PathParam("name") String name, TeamDTO teamDTO) {
        return Response.status(201).entity(teamRepository.updateTeam(name, teamDTO)).build();
    }

    @Transactional
    @DELETE
    @Path("/{id}")
    public Response deleteTeamById(@PathParam("id") String id) {
        teamRepository.deleteTeam(UUID.fromString(id));
        return Response.status(200).entity(id).build();
    }

    @Transactional
    @DELETE
    @Path("/{name}")
    public Response deleteTeam(@PathParam("name") String name) {
        teamRepository.deleteTeam(name);
        return Response.status(200).build();
    }
    @Transactional
    @POST
    public Response create(TeamDTO teamDTO) {
        Team team = teamRepository.createTeam(teamDTO);
        logger.infov("Creating team with id {0}", team.getId());

        return Response.ok(team).status(201).build();
    }
}
