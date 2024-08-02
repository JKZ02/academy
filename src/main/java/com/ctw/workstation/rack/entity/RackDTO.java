package com.ctw.workstation.rack.entity;

import com.ctw.workstation.Location;
import com.ctw.workstation.Status;

import java.util.UUID;

public class RackDTO {
    private String id;
    private String serialNumber;
    private Status status;
    private UUID teamId;
    private Location defaultLocation;

    public RackDTO(String id, String serialNumber, Status status, UUID teamId, Location defaultLocation) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.teamId = teamId;
        this.defaultLocation = defaultLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public void setTeamId(UUID teamId) {
        this.teamId = teamId;
    }

    public Location getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(Location defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

}
