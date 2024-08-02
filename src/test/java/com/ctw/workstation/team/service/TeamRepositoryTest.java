package com.ctw.workstation.team.service;

import com.ctw.workstation.Location;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@QuarkusTest
class TeamRepositoryTest {

    @InjectMock
    TeamRepository teamRepository;

    @Test
    void getAll() {
        //given
        TeamDTO a = new TeamDTO("CTW", "CTWProduct", Location.BRAGA);
        TeamDTO b = new TeamDTO("BMW", "BMWProduct", Location.PORTO);
        List<TeamDTO> teams = Arrays.asList(a,b);

        TeamRepository teamRepositoryMocked = Mockito.mock(TeamRepository.class);

        //when
        Mockito.when(teamRepository.getAll()).thenReturn(teams);

        List<TeamDTO> result = teamRepository.getAll();

        //then
        assertEquals(2, result.size());
        assertEquals("CTW", result.get(0).getName());
        assertEquals("CTWProduct", result.get(0).getProduct());
        assertEquals(Location.BRAGA, result.get(0).getLocation());
        assertEquals("BMW", result.get(1).getName());
        assertEquals("BMWProduct", result.get(1).getProduct());
        assertEquals(Location.PORTO, result.get(1).getLocation());

    }

    @Test
    void findByName() {
        //given
        Team a = new Team("CTW", "CTWProduct", Location.BRAGA);

        TeamRepository teamRepositoryMocked = Mockito.mock(TeamRepository.class);

        //when
        Mockito.when(teamRepository.findByName("CTW")).thenReturn(a);

        Team result = teamRepository.findByName("CTW");

        //then
        assertEquals(a, result);
    }

    @Test
    void createTeam() {
        //given
        TeamDTO a = new TeamDTO("CTW", "CTWProduct", Location.BRAGA);

        TeamRepository teamRepositoryMocked = Mockito.mock(TeamRepository.class);

        //when
        Mockito.when(teamRepository.createTeam(a))
                .thenReturn(new Team(a.getName(), a.getProduct(), a.getLocation()));

        Team result = teamRepository.createTeam(a);

        //then
        assertEquals(new Team(a.getName(), a.getProduct(), a.getLocation()), result);
    }

    @Test
    void addTeam() {
    }
}