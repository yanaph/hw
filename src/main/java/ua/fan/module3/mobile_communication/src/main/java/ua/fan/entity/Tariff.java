package ua.fan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private  String tariffName;
    private Double pricePerMonth;
    @OneToMany(mappedBy = "tariff", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Subscriber> subscribers;

    public Tariff(String tariffName, Double pricePerMonth) {
        this.tariffName = tariffName;
        this.pricePerMonth = pricePerMonth;
    }
}
