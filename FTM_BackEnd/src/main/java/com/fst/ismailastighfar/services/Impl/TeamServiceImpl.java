package com.fst.ismailastighfar.services.Impl;

import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Country;
import com.fst.ismailastighfar.exceptions.TeamNotFoundException;
import com.fst.ismailastighfar.repositories.TeamRepository;
import com.fst.ismailastighfar.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;
    @Override
    public Team getTeam(Long id) throws TeamNotFoundException {
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new TeamNotFoundException("team not found")
        );
        return team ;
    }

    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Long id, Team team) throws TeamNotFoundException {
        Team newTeam = getTeam(id);
        newTeam.setName(team.getName());
        newTeam.setCountry(team.getCountry());
        return teamRepository.save(newTeam);
    }

    @Override
    public void deleteTeam(Long id) {
       teamRepository.deleteById(id);
    }

    @Override
    public List<Team> getTeamsByCountry(Country country) {
        return teamRepository.findByCountry(country);
    }
}
