package com.fst.ismailastighfar.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fst.ismailastighfar.enums.City;
import com.fst.ismailastighfar.enums.Stadiums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique=true)
    private Stadiums name;
    @Enumerated(EnumType.STRING)
    private City city;
    @OneToMany(mappedBy = "stadium")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Match> matches;
}
