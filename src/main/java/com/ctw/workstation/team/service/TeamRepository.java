package com.ctw.workstation.team.service;

import com.ctw.workstation.Location;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TeamRepository implements PanacheRepository<Team> {


    public List<TeamDTO> getAll() {
        return listAll().stream()
                .map(x -> new TeamDTO(x.getName(),x.getProduct(), x.getDefaultLocation()))
                .toList();
    }

    public Team findByName(String name) {
        return find("name", name).firstResult();
    }

    public Team createTeam(TeamDTO teamDTO) {

        Team team = new Team(teamDTO.getName(), teamDTO.getProduct(), teamDTO.getLocation());

        persist(team);

        return team;
    }

    public TeamDTO updateTeam(UUID uuid, TeamDTO teamDTO) {
        Team team = find("id", uuid).firstResult();
        team.setName(teamDTO.getName());
        team.setProduct(teamDTO.getProduct());
        team.setDefaultLocation(teamDTO.getLocation());
        persist(team);
        return teamToDTO(team);
    }
    public TeamDTO updateTeam(String name, TeamDTO teamDTO) {
        Team team = find("name", name).firstResult();
        team.setName(teamDTO.getName());
        team.setProduct(teamDTO.getProduct());
        team.setDefaultLocation(teamDTO.getLocation());
        persist(team);
        return teamToDTO(team);
    }

    public void deleteTeam(UUID id) {
        delete("id", id);
    }
    public void deleteTeam(String name) {
        delete("name", name);
    }

    public TeamDTO teamToDTO(Team team) {
        return new TeamDTO(team.getName(), team.getProduct(), team.getDefaultLocation());
    }

}
