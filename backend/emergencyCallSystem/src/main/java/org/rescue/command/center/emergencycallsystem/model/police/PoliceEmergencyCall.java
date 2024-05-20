package org.rescue.command.center.emergencycallsystem.model.police;

import lombok.Getter;
import lombok.Setter;

import org.rescue.command.center.base.userManagement.model.User;
import org.rescue.command.center.emergencycallsystem.enums.PoliceEmergencyCallKeyword;

import org.rescue.command.center.emergencycallsystem.model.EmergencyCallState;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;

@Node
@Getter @Setter
public class PoliceEmergencyCall {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime timestamp;
    private PoliceEmergencyCallKeyword keyword;
    private String location;
    private String information;
    private String communicatorName;
    private String communicatorPhoneNumber;

    @Relationship(type = "created_by", direction = Relationship.Direction.INCOMING)
    private User dispatcher;

    @Relationship(type = "is_in_state", direction = Relationship.Direction.OUTGOING)
    private EmergencyCallState emergencyCallState;
}