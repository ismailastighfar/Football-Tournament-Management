package com.fst.ismailastighfar.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fst.ismailastighfar.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Referee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    @Enumerated(EnumType.STRING)
    private Country nationality;
    @OneToMany(mappedBy = "referee")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Match> matches;
}
