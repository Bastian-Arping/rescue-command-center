package org.rescue.command.center.base.emergencycallsystem.repository;

import org.rescue.command.center.base.emergencycallsystem.model.District;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface DistrictRepository extends Neo4jRepository<District, String> {
    District findByName(String name);

    @Query("MATCH (u:User)-[:works_in]->(d:District) WHERE u.username = $username RETURN d.name")
    String findDistrictNameByUsername(String username);
}