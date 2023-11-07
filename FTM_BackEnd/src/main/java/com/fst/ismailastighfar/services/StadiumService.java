package com.fst.ismailastighfar.services;

import com.fst.ismailastighfar.entities.Stadium;
import com.fst.ismailastighfar.exceptions.StadiumNotFoundException;

import java.util.List;

public interface StadiumService {
    Stadium getStadium(Long id) throws StadiumNotFoundException;
    List<Stadium> getStadiums();
    Stadium saveStadium(Stadium stadium);
    Stadium updateStadium(Long id , Stadium stadium) throws StadiumNotFoundException;
    void deleteStadium(Long id);
}
