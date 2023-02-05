package ua.fan.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String activityText;
    @ManyToOne
    @JoinColumn (name = "activityType_id")
    private ActivityType activityType;
    @ManyToOne
    @JoinColumn (name = "subscriber_id")
    private Subscriber subscriber;

    @Override
    public String toString() {
        return "Activity{" +
                "id = '" + id + '\'' +
                ", activityText='" + activityText + '}';
    }
}
