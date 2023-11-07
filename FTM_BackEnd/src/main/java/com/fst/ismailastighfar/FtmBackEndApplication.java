package com.fst.ismailastighfar;

import com.fst.ismailastighfar.entities.*;
import com.fst.ismailastighfar.enums.City;
import com.fst.ismailastighfar.enums.Country;
import com.fst.ismailastighfar.enums.Position;
import com.fst.ismailastighfar.enums.Stadiums;
import com.fst.ismailastighfar.exceptions.TeamNotFoundException;
import com.fst.ismailastighfar.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class FtmBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(FtmBackEndApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            MatchService matchService,
            PlayerService playerService,
            TeamService teamService,
            RefereeService refereeService,
            StadiumService stadiumService
    ){
        return args -> {
            // create referee
            Stream.of("Anthony Taylor","Martin Atkinson","Daniele Orsato","Felix Brych").forEach(name->{
                    Referee referee = new Referee();
                    referee.setName(name);
                    referee.setNationality(Country.ENGLAND);
                    refereeService.saveReferee(referee);
                    });
            // create stadium
            Stadium stadium = new Stadium();
            stadium.setName(Stadiums.METROPOLITANO);
            stadium.setCity(City.MADRID);
            stadiumService.saveStadium(stadium);

            Stadium stadium1 = new Stadium();
            stadium1.setName(Stadiums.PARC_DE_PRINCES);
            stadium1.setCity(City.PARIS);
            stadiumService.saveStadium(stadium1);

            Stadium stadium2 = new Stadium();
            stadium2.setName(Stadiums.MOHAMMED_V);
            stadium2.setCity(City.CASABLANCA);
            stadiumService.saveStadium(stadium2);

            // create Team
            Team team = new Team();
            team.setName("PSG");
            team.setCountry(Country.FRANCE);
            teamService.saveTeam(team);
            Team team1 = new Team();
            team1.setName("ATL MADRID");
            team1.setCountry(Country.SPAIN);
            teamService.saveTeam(team1);
            Team team2 = new Team();
            team2.setName("RCA");
            team2.setCountry(Country.MAROC);
            teamService.saveTeam(team2);
            Team team3 = new Team();
            team3.setName("WAC");
            team3.setCountry(Country.MAROC);
            teamService.saveTeam(team3);

            //create players
            Stream.of("Kylian Mbappe","Ousmane Dembele")
                    .forEach(name->{
                    try {
                        playerService.savePlayer(name,Position.FORWARD,
                                team.getName());
                    } catch (TeamNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    });
            Stream.of("Saúl Ñíguez","Koke")
                    .forEach(name->{
                        try {
                            playerService.savePlayer(name,Position.MIDFIELDER,
                                    team1.getName());
                        } catch (TeamNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    });



            // create match

            Date specificDate = new Date(124, 1, 28);
            String ref = refereeService.getReferee(1L).getName();
            matchService.saveMATCH(
                    specificDate,
                    new Date(),
                    team1.getName(),
                    team.getName(),
                    stadium.getName(),
                    ref
            );

            String ref2 = refereeService.getReferee(3L).getName();
            matchService.saveMATCH(
                    specificDate,
                    new Date(),
                    team3.getName(),
                    team.getName(),
                    stadium1.getName(),
                    ref2
            );


            String ref1 = refereeService.getReferee(2L).getName();
            matchService.saveMATCH(
                    specificDate,
                    new Date(),
                    team2.getName(),
                    team3.getName(),
                    stadium2.getName(),
                    ref1
            );

            Date specificDate1 = new Date(123, 9, 12);
            matchService.saveMATCH(
                    specificDate1,
                    new Date(),
                    team.getName(),
                    team3.getName(),
                    stadium.getName(),
                    ref
            );
            matchService.saveMATCH(
                    specificDate1,
                    new Date(),
                    team2.getName(),
                    team1.getName(),
                    stadium2.getName(),
                    ref1
            );

        };
    }
}
