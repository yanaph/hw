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
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String modelName;
    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Subscriber> subscribers;
    @ManyToOne
    @JoinColumn (name = "deviceType_id")
    private DeviceType deviceType;

    public Device(String modelName) {
        this.modelName = modelName;
    }
}
