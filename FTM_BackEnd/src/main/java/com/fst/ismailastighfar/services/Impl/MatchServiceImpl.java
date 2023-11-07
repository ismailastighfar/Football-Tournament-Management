package com.fst.ismailastighfar.services.Impl;

import com.fst.ismailastighfar.entities.Match;
import com.fst.ismailastighfar.entities.Referee;
import com.fst.ismailastighfar.entities.Stadium;
import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Stadiums;
import com.fst.ismailastighfar.exceptions.*;
import com.fst.ismailastighfar.repositories.MatchRepository;
import com.fst.ismailastighfar.repositories.RefereeRepository;
import com.fst.ismailastighfar.repositories.StadiumRepository;
import com.fst.ismailastighfar.repositories.TeamRepository;
import com.fst.ismailastighfar.services.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class MatchServiceImpl implements MatchService {

    private MatchRepository matchRepository;
    private TeamRepository teamRepository;
    private RefereeRepository refereeRepository;
    private StadiumRepository stadiumRepository;
    @Override
    public Match saveMATCH(Date date, Date hour, String team1, String team2, Stadiums stadium, String referee) throws TeamNotFoundException, RefereeNotFoundException, StadiumNotFoundException, DateHasPassedException {
      Match match = new Match();
      Date currentDate = new Date();
        if (date.before(currentDate)) {
           throw new DateHasPassedException("date passed specify a future date");
        } else {
            match.setMatchDate(date);
        }
        match.setMatchDate(date);
        match.setMatchHour(hour);
      Team firstTeam = teamRepository.findByName(team1);
      if (firstTeam == null){
          throw new TeamNotFoundException("team1 not found");
      }
      Team secondTeam = teamRepository.findByName(team2);
      if (secondTeam == null){
            throw new TeamNotFoundException("team2 not found");
      }
      match.setTeam1(firstTeam);
      match.setTeam2(secondTeam);
      Referee refereeMatch = refereeRepository.findByName(referee);
      if (refereeMatch == null)
          throw new RefereeNotFoundException("referee not found");
      match.setReferee(refereeMatch);
      Stadium stadiumMatch = stadiumRepository.findByName(stadium);
      if (stadiumMatch == null)
          throw new StadiumNotFoundException("Stadium not found");
      match.setStadium(stadiumMatch);

      return matchRepository.save(match);
    }

    @Override
    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match getMatch(Long id) throws MatchNotFoundException {
        Match match = matchRepository.findById(id).orElseThrow(() ->
             new MatchNotFoundException("match not found"));
        return match ;
    }

    @Override
    public Match updateMatch(Long id,Date date, Date hour, Stadiums stadium, String referee) throws MatchNotFoundException, DateHasPassedException, TeamNotFoundException, RefereeNotFoundException, StadiumNotFoundException {
        Match match = getMatch(id);
        Date currentDate = new Date();
        if (date.before(currentDate)) {
            throw new DateHasPassedException("date passed specify a future date");
        } else {
            match.setMatchDate(date);
        }
        match.setMatchHour(hour);
        Referee refereeMatch = refereeRepository.findByName(referee);
        if (refereeMatch == null)
            throw new RefereeNotFoundException("referee not found");
        match.setReferee(refereeMatch);
        Stadium stadiumMatch = stadiumRepository.findByName(stadium);
        if (stadiumMatch == null)
            throw new StadiumNotFoundException("Stadium not found");
        match.setStadium(stadiumMatch);

        return matchRepository.save(match);
    }

    @Override
    public void DeleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    @Override
    public List<Match> getMatchesByDate(Date date) {
        return matchRepository.findByMatchDate(date);
    }

    @Override
    public Stadium getStadiumByMatch(Long id) throws MatchNotFoundException {
        Match match = getMatch(id);
        return match.getStadium();
    }

    @Override
    public List<Team> getTeamsByMatch(Long id) throws MatchNotFoundException {
        Match match = getMatch(id);
        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();
        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        return teams;
    }

    @Override
    public void deleteMatchesByDate() {
        Date date = new Date();
        matchRepository.deleteAllByMatchDateLessThan(date);
    }
}
