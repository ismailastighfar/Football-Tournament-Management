package com.fst.ismailastighfar.services.Impl;

import com.fst.ismailastighfar.entities.Referee;
import com.fst.ismailastighfar.exceptions.RefereeNotFoundException;
import com.fst.ismailastighfar.repositories.RefereeRepository;
import com.fst.ismailastighfar.services.RefereeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RefereeServiceImpl implements RefereeService {

    private RefereeRepository refereeRepository;
    @Override
    public Referee getReferee(Long id) throws RefereeNotFoundException {
        Referee referee = refereeRepository.findById(id).orElseThrow(
                () -> new RefereeNotFoundException("referee not found")
                );
        return referee ;
    }

    @Override
    public List<Referee> getReferees() {
        return refereeRepository.findAll();
    }

    @Override
    public Referee saveReferee(Referee referee) {
        return refereeRepository.save(referee);
    }

    @Override
    public Referee updateReferee(Long id, Referee referee) throws RefereeNotFoundException {
        Referee newReferee = getReferee(id);
        newReferee.setName(referee.getName());
        newReferee.setNationality(referee.getNationality());
        return refereeRepository.save(newReferee);
    }

    @Override
    public void deleteReferee(Long id) {
      refereeRepository.deleteById(id);
    }
}
