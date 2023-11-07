package com.fst.ismailastighfar.repositories;

import com.fst.ismailastighfar.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match,Long> {
    List<Match> findByMatchDate(Date date);
    void deleteAllByMatchDateLessThan(Date date);
}
