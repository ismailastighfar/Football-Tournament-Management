package com.fst.ismailastighfar.web;

import com.fst.ismailastighfar.entities.Referee;
import com.fst.ismailastighfar.exceptions.RefereeNotFoundException;
import com.fst.ismailastighfar.services.RefereeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RefereeRestController {
    private RefereeService refereeService;

    @GetMapping("/referees/{id}")
    public Referee getReferee(@PathVariable Long id) throws RefereeNotFoundException {
        return refereeService.getReferee(id);
    }

    @GetMapping("/referees")
    public List<Referee> getReferees(){
        return refereeService.getReferees();
    }

    @PostMapping("/referees")
    public Referee saveReferee(@RequestBody Referee referee){
        return refereeService.saveReferee(referee);
    }

    @PutMapping("/referees/{id}")
    public Referee updateReferee(@PathVariable Long id,@RequestBody Referee referee) throws RefereeNotFoundException {
        return refereeService.updateReferee(id,referee);
    }

    @DeleteMapping("/referees/{id}")
    public void deleteReferee(@PathVariable Long id){
        refereeService.deleteReferee(id);
    }
}
