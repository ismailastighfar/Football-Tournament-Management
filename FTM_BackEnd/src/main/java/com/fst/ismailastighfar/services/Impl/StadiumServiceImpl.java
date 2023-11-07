package com.fst.ismailastighfar.services.Impl;

import com.fst.ismailastighfar.entities.Stadium;
import com.fst.ismailastighfar.exceptions.StadiumNotFoundException;
import com.fst.ismailastighfar.repositories.StadiumRepository;
import com.fst.ismailastighfar.services.StadiumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StadiumServiceImpl implements StadiumService {

    private StadiumRepository stadiumRepository;
    @Override
    public Stadium getStadium(Long id) throws StadiumNotFoundException {
       Stadium stadium = stadiumRepository.findById(id).orElseThrow(
               () -> new StadiumNotFoundException("stadium not found"));
       return stadium;
    }

    @Override
    public List<Stadium> getStadiums() {
        return stadiumRepository.findAll();
    }

    @Override
    public Stadium saveStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    @Override
    public Stadium updateStadium(Long id, Stadium stadium) throws StadiumNotFoundException {
        Stadium newStadium = getStadium(id);
        newStadium.setName(stadium.getName());
        newStadium.setCity(stadium.getCity());
        return stadiumRepository.save(newStadium);
    }

    @Override
    public void deleteStadium(Long id) {
       stadiumRepository.deleteById(id);
    }
}
