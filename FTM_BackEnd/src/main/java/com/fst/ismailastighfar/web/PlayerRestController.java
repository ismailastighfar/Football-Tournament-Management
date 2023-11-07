package com.fst.ismailastighfar.web;

import com.fst.ismailastighfar.entities.Player;
import com.fst.ismailastighfar.enums.Position;
import com.fst.ismailastighfar.exceptions.PlayerNotFoundException;
import com.fst.ismailastighfar.exceptions.TeamNotFoundException;
import com.fst.ismailastighfar.services.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerRestController {
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable Long id) throws PlayerNotFoundException {
        return playerService.getPlayer(id);
    }

    @PostMapping("/players")
    public Player savePlayer(@RequestParam String name,
                             @RequestParam Position position,
                             @RequestParam String teamName) throws TeamNotFoundException {
        return playerService.savePlayer(name,position,teamName);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam Position position,
                             @RequestParam String teamName) throws TeamNotFoundException, PlayerNotFoundException {
        return playerService.updatePlayer(id,name,position,teamName);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }

    @GetMapping("/players/team")
    public List<Player> getPlayersByTeam(@RequestParam String teamName) throws TeamNotFoundException {
        return playerService.getPlayersByTeam(teamName);
    }

    @GetMapping("/players/team/position")
    public List<Player> getPlayersByPosAndTeam(@RequestParam Position position,
                                               @RequestParam String teamName) throws TeamNotFoundException {
        return playerService.getPlayersByPosAndTeam(position,teamName);
    }

}
