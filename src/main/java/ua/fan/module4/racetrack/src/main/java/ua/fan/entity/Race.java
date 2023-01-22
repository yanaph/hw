package ua.fan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    @Column(name = "num_of_races")
    private Integer numOfRacers;
    @Column(name = "total_distance")
    private Integer totalDistance;
    @Column(name = "betHorseNumber")
    private Integer betHorseNumber;

    @OneToMany(mappedBy = "race",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private List<Horse> horse_race;

    public Race(LocalDate date, Integer numOfRacers, Integer totalDistance, Integer betHorseNumber) {
        this.date = date;
        this.numOfRacers = numOfRacers;
        this.totalDistance = totalDistance;
        this.betHorseNumber = betHorseNumber;
    }
}
