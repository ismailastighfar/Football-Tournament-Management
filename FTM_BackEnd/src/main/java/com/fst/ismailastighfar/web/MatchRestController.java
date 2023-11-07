package com.fst.ismailastighfar.web;

import com.fst.ismailastighfar.entities.Match;
import com.fst.ismailastighfar.entities.Stadium;
import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Stadiums;
import com.fst.ismailastighfar.exceptions.*;
import com.fst.ismailastighfar.services.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class MatchRestController {

    private MatchService matchService;

    @GetMapping("/matches")
    public List<Match> matches(){
        return matchService.getMatches();
    }

    @GetMapping("/matches/{id}")
    public Match getMatch(@PathVariable Long id) throws MatchNotFoundException {
        return matchService.getMatch(id);
    }

    @PostMapping("/matches")
    public Match saveMatch(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                           @RequestParam @DateTimeFormat(pattern="HH:mm") Date hour,
                           @RequestParam String team1,
                           @RequestParam String team2,
                           @RequestParam Stadiums stadium,
                           @RequestParam String referee
    ) throws RefereeNotFoundException, DateHasPassedException, TeamNotFoundException, StadiumNotFoundException {
        return matchService.saveMATCH(date,hour,team1,team2,stadium,referee);
    }

    @PutMapping("/matches/{id}")
    public Match updateMatch(@PathVariable Long id,
                           @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
                           @RequestParam @DateTimeFormat(pattern="HH:mm") Date hour,
                           @RequestParam Stadiums stadium,
                           @RequestParam String referee
    ) throws RefereeNotFoundException, DateHasPassedException, TeamNotFoundException, MatchNotFoundException, StadiumNotFoundException {
        return matchService.updateMatch(id,date,hour,stadium,referee);
    }

    @DeleteMapping("/matches/{id}")
    public void deleteMatch(@PathVariable Long id){
        matchService.DeleteMatch(id);
    }

    @GetMapping("/matches/date")
    public List<Match> getMatchesByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        return matchService.getMatchesByDate(date);
    }

    @GetMapping("/matches/stadium/{id}")
    public Stadium getStadiumByMatch(@PathVariable Long id) throws MatchNotFoundException {
        return matchService.getStadiumByMatch(id);
    }

    @GetMapping("/matches/{id}/teams")
    public List<Team> getTeamsByMatch(@PathVariable Long id) throws MatchNotFoundException {
        return matchService.getTeamsByMatch(id);
    }

    @DeleteMapping("/matches/date")
    public void deleteMatchesByDate(){
        matchService.deleteMatchesByDate();
    }


}
