package com.ctw.workstation.teammember.service;

import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepository<TeamMember> {

    public List<TeamMember> getAll() {
        return listAll();
    }

}
