package com.fst.ismailastighfar.services;

import com.fst.ismailastighfar.entities.Match;
import com.fst.ismailastighfar.entities.Stadium;
import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Stadiums;
import com.fst.ismailastighfar.exceptions.*;

import java.util.Date;
import java.util.List;

public interface MatchService {
    Match saveMATCH(Date date, Date hour, String team1, String team2, Stadiums stadium, String referee) throws TeamNotFoundException, RefereeNotFoundException, StadiumNotFoundException, DateHasPassedException;
    List<Match> getMatches();
    Match getMatch(Long id) throws MatchNotFoundException;
    Match updateMatch(Long id,Date date, Date hour, Stadiums stadium, String referee) throws MatchNotFoundException, DateHasPassedException, TeamNotFoundException, RefereeNotFoundException, StadiumNotFoundException;
    void DeleteMatch(Long id);
    List<Match> getMatchesByDate(Date date);
    Stadium getStadiumByMatch(Long id) throws MatchNotFoundException;
    List<Team> getTeamsByMatch(Long id) throws MatchNotFoundException;
    void deleteMatchesByDate();
}