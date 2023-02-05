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
public class ActivityType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String typeName;
    @OneToMany (mappedBy = "activityType", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Activity> activities;

    public ActivityType(String typeName) {
        this.typeName = typeName;
    }
}
