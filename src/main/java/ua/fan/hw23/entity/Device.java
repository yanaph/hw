package ua.fan.hw23.entity;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Device {
    private Integer id;
    private String type;
    private String modelName;
    private Integer price;
    private LocalDate manufactureDate;
    private String description;
    private Boolean inStock;
    private Integer factoryId;

    public Device(String type, String modelName, Integer price, LocalDate manufactureDate, String description, Boolean inStock, Integer factoryId) {
        this.type = type;
        this.modelName = modelName;
        this.price = price;
        this.manufactureDate = manufactureDate;
        this.description = description;
        this.inStock = inStock;
        this.factoryId = factoryId;
    }

    @Override
    public String toString() {
        return "Device{" +
                "\nid: " + id +
                "\ntype: " + type +
                "\nmodel: " + modelName +
                "\nprice: " + price +
                "\nmanufacture date: " + manufactureDate +
                "\ndescription: " + description +
                "\nin Stock:b" + (inStock ? "yes" : "no") +
                "\nfactory id: '" + factoryId +
                '}';
    }
}

