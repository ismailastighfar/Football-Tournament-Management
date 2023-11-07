package com.fst.ismailastighfar.repositories;

import com.fst.ismailastighfar.entities.Team;
import com.fst.ismailastighfar.enums.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team,Long> {
    Team findByName(String name);
    List<Team> findByCountry(Country country);
}
