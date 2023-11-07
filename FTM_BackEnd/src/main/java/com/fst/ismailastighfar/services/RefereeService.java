package com.fst.ismailastighfar.services;

import com.fst.ismailastighfar.entities.Referee;
import com.fst.ismailastighfar.exceptions.RefereeNotFoundException;

import java.util.List;

public interface RefereeService {
    Referee getReferee(Long id) throws RefereeNotFoundException;
    List<Referee> getReferees();
    Referee saveReferee(Referee referee);
    Referee updateReferee(Long id,Referee referee) throws RefereeNotFoundException;
    void deleteReferee(Long id);
}
