package com.fst.ismailastighfar.services;

import com.fst.ismailastighfar.entities.Player;
import com.fst.ismailastighfar.enums.Position;
import com.fst.ismailastighfar.exceptions.PlayerNotFoundException;
import com.fst.ismailastighfar.exceptions.TeamNotFoundException;

import java.util.List;

public interface PlayerService {

    List<Player> getPlayers();
    Player getPlayer(Long id) throws PlayerNotFoundException;
    Player savePlayer(String name, Position position,String teamName) throws TeamNotFoundException;
    Player updatePlayer(Long id,String name, Position position,String teamName) throws PlayerNotFoundException, TeamNotFoundException;
    void deletePlayer(Long id);
    List<Player> getPlayersByTeam(String team) throws TeamNotFoundException;
    List<Player> getPlayersByPosAndTeam(Position position , String teamName) throws TeamNotFoundException;

}
