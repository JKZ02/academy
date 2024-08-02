package com.ctw.workstation.teammember.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "T_TEAM_MEMBER")
public class TeamMember extends PanacheEntityBase {

    @Id
    @Column(insertable = false)
    private UUID id;
    @Column(name = "ctw_id", length = 8, nullable = false)
    private String ctwId;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
    @Column(name = "team_id")
    private UUID teamId;
}
