package com.fst.ismailastighfar.services.Impl;

import com.fst.ismailastighfar.entities.Player;
import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Position;
import com.fst.ismailastighfar.exceptions.PlayerNotFoundException;
import com.fst.ismailastighfar.exceptions.TeamNotFoundException;
import com.fst.ismailastighfar.repositories.PlayerRepository;
import com.fst.ismailastighfar.repositories.TeamRepository;
import com.fst.ismailastighfar.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;
    @Override
    public List<Player> getPlayers() {
        return playerRepository.findAll() ;
    }

    @Override
    public Player getPlayer(Long id) throws PlayerNotFoundException {
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new PlayerNotFoundException("player not found")
        );
        return player;
    }

    @Override
    public Player savePlayer(String name, Position position, String teamName) throws TeamNotFoundException {
        Player player = new Player();
        player.setName(name);
        player.setPosition(position);
        Team team = teamRepository.findByName(teamName);
        if (team == null)
            throw new TeamNotFoundException("team not found");
        player.setTeam(team);
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Long id, String name, Position position, String teamName) throws PlayerNotFoundException, TeamNotFoundException {
        Player player = getPlayer(id);
        player.setName(name);
        player.setPosition(position);
        Team team = teamRepository.findByName(teamName);
        if (team == null)
            throw new TeamNotFoundException("team not found");
        player.setTeam(team);
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
      playerRepository.deleteById(id);
    }

    @Override
    public List<Player> getPlayersByTeam(String teamName) throws TeamNotFoundException {
        Team team = teamRepository.findByName(teamName);
        if (team == null)
            throw new TeamNotFoundException("team not found");
        return playerRepository.findByTeam(team);
    }

    @Override
    public List<Player> getPlayersByPosAndTeam(Position position, String teamName) throws TeamNotFoundException {
        Team team = teamRepository.findByName(teamName);
        if (team == null)
            throw new TeamNotFoundException("team not found");
        return playerRepository.findByPositionAndTeam(position,team) ;
    }
}
