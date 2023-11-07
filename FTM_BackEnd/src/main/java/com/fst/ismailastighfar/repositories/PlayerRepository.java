package com.fst.ismailastighfar.repositories;

import com.fst.ismailastighfar.entities.Player;
import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    List<Player> findByTeam(Team team);
    List<Player> findByPositionAndTeam(Position position,Team team);
}
