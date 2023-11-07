package com.fst.ismailastighfar.web;

import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Country;
import com.fst.ismailastighfar.exceptions.TeamNotFoundException;
import com.fst.ismailastighfar.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeamRestController {

    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(@PathVariable Long id) throws TeamNotFoundException {
        return teamService.getTeam(id);
    }

    @PostMapping("/teams")
    public Team saveTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @PutMapping ("/teams/{id}")
    public Team updateTeam(@PathVariable Long id,@RequestBody Team team) throws TeamNotFoundException {
        return teamService.updateTeam(id,team);
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }

    @GetMapping("/teams/country")
    public List<Team> getTeamsByCountry(@RequestParam Country country){
        return teamService.getTeamsByCountry(country);
    }


}
