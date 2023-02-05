package ua.fan.hw23.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Factory {
    private Integer id;
    private String name;
    private String country;

    @Override
    public String toString() {
        return "Factory{" +
                "\nid: " + id +
                "\nname: " + name +
                "\ncountry: " + country +
                '}';
    }
}
