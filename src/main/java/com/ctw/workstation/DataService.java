package com.ctw.workstation;

import com.ctw.workstation.booking.entity.BookingDTO;
import com.ctw.workstation.rack.entity.RackDTO;
import com.ctw.workstation.team.entity.TeamDTO;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataService {
    private static DataService instance;
    private List<RackDTO> racks;
    private List<BookingDTO> bookings;
    private List<TeamDTO> teams;
    private List<TeamMemberDTO> teamMembers;

    public static synchronized DataService getInstance() {

        if (instance == null) {
            instance = new DataService();
        }

        return instance;
    }

    private DataService() {
        this.racks = new ArrayList<RackDTO>();
        this.bookings = new ArrayList<BookingDTO>();
        this.teams = new ArrayList<TeamDTO>();
        this.teamMembers = new ArrayList<TeamMemberDTO>();
    }

    //region racks
    public List<RackDTO> getAllRacks() {
        return racks;
    }
    public List<RackDTO> getAllRacks(Status status) {
        List<RackDTO> statusRacks = new ArrayList<RackDTO>();
        for (RackDTO rack : racks) {
            if (rack.getStatus().equals(status)) {
                statusRacks.add(rack);
            }
        }
        return statusRacks;
    }

    public RackDTO findRack(String id) {
        for (RackDTO rack : racks) {
            if (rack.getId().equals(id)) {
                return rack;
            }
        }
        return null;
    }

    public void updateRack(RackDTO rackDTO) {
        int index = 0;
        for (RackDTO rack : racks) {
            if (rack.getId().equals(rackDTO.getId())) {
                racks.set(index, rackDTO);
            }
            index++;
        }
    }

    public void deleteRack(String id) {
        racks.removeIf(rack -> rack.getId().equals(id));
    }

    public void createRack(RackDTO rackDTO) {
        rackDTO.setId(UUID.randomUUID().toString());
        if(!racks.contains(rackDTO)) {
            racks.add(rackDTO);
        }
    }
    //endregion

    //region booking
    public List<BookingDTO> getAllBookings() {
        return bookings;
    }

    public BookingDTO findBooking(String id) {
        for (BookingDTO booking : bookings) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        return null;
    }

    public void updateBooking(BookingDTO bookingDTO) {
        int index = 0;
        for (BookingDTO booking : bookings) {
            if (booking.getId().equals(bookingDTO.getId())) {
                bookings.set(index, bookingDTO);
            }
            index++;
        }
    }

    public void deleteBooking(String id) {
        bookings.removeIf(booking -> booking.getId().equals(id));
    }

    public void createBooking(BookingDTO bookingDTO) {
        bookingDTO.setId(UUID.randomUUID().toString());
        if(!bookings.contains(bookingDTO)) {
            bookings.add(bookingDTO);
        }
    }
    //endregion

    //region teams
    public List<TeamDTO> getAllTeams() {
        return teams;
    }

   /* public TeamDTO findTeam(String id) {
        for (TeamDTO team : teams) {
            if (team.getId().equals(id)) {
                return team;
            }
        }
        return null;
    }*/

    /*public void updateTeam(TeamDTO teamDTO) {
        int index = 0;
        for (TeamDTO team : teams) {
            if (team.getId().equals(teamDTO.getId())) {
                teams.set(index, teamDTO);
            }
            index++;
        }
    }*/

    /*public void deleteTeam(String id) {
        teams.removeIf(team -> team.getId().equals(id));
    }*/

    public void createTeam(TeamDTO teamDTO) {
        if(!teams.contains(teamDTO)) {
            teams.add(teamDTO);
        }
    }
    //endregion

    //region team member
    public List<TeamMemberDTO> getAllTeamMembers() {
        return teamMembers;
    }

    public TeamMemberDTO createTeamMember(TeamMemberDTO teamMemberDTO) {
        teamMembers.add(teamMemberDTO);
        return teamMemberDTO;
    }
    //endregion
}
