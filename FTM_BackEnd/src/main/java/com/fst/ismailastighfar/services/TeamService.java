package com.fst.ismailastighfar.services;

import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Country;
import com.fst.ismailastighfar.exceptions.TeamNotFoundException;

import java.util.List;

public interface TeamService {
    Team getTeam(Long id) throws TeamNotFoundException;
    List<Team> getTeams();
    Team saveTeam(Team team);
    Team updateTeam(Long id,Team team) throws TeamNotFoundException;
    void deleteTeam(Long id);
    List<Team> getTeamsByCountry(Country country);
}
