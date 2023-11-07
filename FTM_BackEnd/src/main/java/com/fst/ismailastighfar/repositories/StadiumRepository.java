package com.fst.ismailastighfar.repositories;

import com.fst.ismailastighfar.entities.Stadium;
import com.fst.ismailastighfar.enums.Stadiums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium,Long> {
    Stadium findByName(Stadiums name);
}
