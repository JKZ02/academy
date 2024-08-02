package com.ctw.workstation.team.boundary;

import com.ctw.workstation.DatabaseTestResource;
import com.ctw.workstation.Location;
/*
import com.ctw.workstation.WiremockResource;
*/
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.team.service.TeamRepository;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.RandomStringUtils;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@QuarkusTestResource(DatabaseTestResource.class)
/*
@QuarkusTestResource(WiremockResource.class)
*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestHTTPEndpoint(TeamResource.class)
class TeamResourceTest {

    @Inject
    TeamRepository teamRepository;

    Logger logger = Logger.getLogger(TeamResourceTest.class);

    @Test
    void getAllTeams() {
        /*//given
        TeamDTO a = new TeamDTO("CTW", "CTWProduct", Location.BRAGA);
        TeamDTO b = new TeamDTO("BMW", "BMWProduct", Location.PORTO);
        TeamDTO c = new TeamDTO("MINI", "MINIProduct", Location.LISBON);
        List<TeamDTO> teams = Arrays.asList(a,b);

        //when
        Mockito.when(teamRepository.getAll()).thenReturn(teams);

        List<TeamDTO> result = teamRepository.getAll();

        //then
        assertThat(result).hasSize(2);
        assertThat(result).contains(a, b);*/

        List<TeamDTO> result = (List<TeamDTO>) given()
                .when().get()
                .then()
                .extract().as(new TypeRef<List<TeamDTO>>() {});

        assertThat(result).hasSize(3);
        assertThat(result.getFirst().getName()).isEqualTo("Team 1");
        /*assertEquals(2, result.size());
        assertEquals("CTW", result.get(0).getName());
        assertEquals("CTWProduct", result.get(0).getProduct());
        assertEquals(Location.BRAGA, result.get(0).getLocation());
        assertEquals("BMW", result.get(1).getName());
        assertEquals("BMWProduct", result.get(1).getProduct());
        assertEquals(Location.PORTO, result.get(1).getLocation());*/

    }

    @Test
    void findTeam() {
        /*//given
        Team a = new Team("CTW", "CTWProduct", Location.BRAGA);

        //when
        Mockito.when(teamRepository.findByName("CTW")).thenReturn(a);

        Team result = teamRepository.findByName("CTW");

        //then

        //assertEquals(a, result);
        assertThat(result).isEqualTo(a);*/
        //????? not working
        //stubFor(get(urlEqualTo("/external/hello")))

        String name = teamRepository.findByName("Team 1").getName();
        given().contentType("application/json")
                .when()
                .get("/"+name)
                .then().statusCode(200);

    }

    @Test
    void updateTeam() {
        TeamDTO result = given().contentType("application/json")
                .body(new TeamDTO(
                        "Team Updated",
                        "Product Updated",
                        Location.PORTO)
                )
                .when()
                .put("/Team 1")
                .then().extract().as(TeamDTO.class);
        System.out.println(result);

        assertThat(result.getName()).isEqualTo("Team Updated");
    }

    @Test
    void deleteTeam() {
        String id = teamRepository.findByName("Team 2").getId().toString();
        String result = given().contentType("application/json")
                .when()
                .delete("/"+id)
                .then().extract().asString();

        assertThat(result).isEqualTo(id);


/*
        assertThat(result).isEqualTo(id + "deleted");
*/
    }

    @Test
    void createTeam() {

        given().contentType("application/json")
                .body(new TeamDTO(
                        "Team " + RandomStringUtils.randomAlphabetic(5),
                        "Product " + RandomStringUtils.randomAlphabetic(5),
                        Location.LISBON)
                )
                .when()
                .post()
                .then().statusCode(201).extract().as(Team.class);
    }

    @BeforeEach
    void setup() {
        populateDb();
    }

    @AfterAll
    @Transactional
    void finish() {
        for (TeamDTO teamDTO : teamRepository.getAll()) {
            logger.info("Name: " + teamDTO.getName() + " Product: " + teamDTO.getProduct() + " Location: " + teamDTO.getLocation() );
        }
    }

    @Transactional
    void populateDb() {
        teamRepository.deleteAll();
        teamRepository.createTeam(new TeamDTO("Team 1","Product 1", Location.BRAGA));
        teamRepository.createTeam(new TeamDTO("Team 2","Product 2", Location.LISBON));
        teamRepository.createTeam(new TeamDTO("Team 3","Product 3", Location.PORTO));
    }
}