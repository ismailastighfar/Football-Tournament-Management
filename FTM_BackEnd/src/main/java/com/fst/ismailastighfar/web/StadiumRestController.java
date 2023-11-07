package com.fst.ismailastighfar.web;

import com.fst.ismailastighfar.entities.Stadium;
import com.fst.ismailastighfar.exceptions.StadiumNotFoundException;
import com.fst.ismailastighfar.services.StadiumService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StadiumRestController {
    private StadiumService stadiumService ;

    @GetMapping("/stadiums/{id}")
    public Stadium getStadium(@PathVariable Long id) throws StadiumNotFoundException {
        return stadiumService.getStadium(id);
    }

    @GetMapping("/stadiums")
    public List<Stadium> getStadiums(){
        return stadiumService.getStadiums();
    }

    @PostMapping("/stadiums")
    public Stadium saveStadium(@RequestBody Stadium stadium){
        return stadiumService.saveStadium(stadium);
    }

    @PutMapping("/stadiums/{id}")
    public Stadium updateStadium(@PathVariable Long id,@RequestBody Stadium stadium) throws StadiumNotFoundException {
        return stadiumService.updateStadium(id,stadium);
    }

    @DeleteMapping("/stadiums/{id}")
    public void deleteStadium(@PathVariable Long id){
        stadiumService.deleteStadium(id);
    }
}
