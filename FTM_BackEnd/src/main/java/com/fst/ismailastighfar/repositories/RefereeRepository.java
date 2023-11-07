package com.fst.ismailastighfar.repositories;

import com.fst.ismailastighfar.entities.Referee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RefereeRepository extends JpaRepository<Referee,Long> {
    Referee findByName(String name);
}
