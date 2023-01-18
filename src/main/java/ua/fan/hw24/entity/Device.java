package ua.fan.hw24.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String type;
    private String modelName;
    private int price;
    private LocalDateTime manufactureDate;
    private String description;
    private boolean inStock;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    private Factory factory;

    @PreRemove
    private void removeDeviceFromFactory() {
        factory.getDevices().removeIf(device -> device.getId().equals(this.id));
    }

    public Device(String type, String modelName, int price, String description, boolean inStock, Factory factory) {
        this.type = type;
        this.modelName = modelName;
        this.price = price;
        this.manufactureDate = LocalDateTime.now();
        this.description = description;
        this.inStock = inStock;
        this.factory = factory;
    }
}