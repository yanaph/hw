package ua.fan.module2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Device {
    private String series;
    private String screenType;
    private int price;
}
