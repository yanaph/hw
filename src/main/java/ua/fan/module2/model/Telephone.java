package ua.fan.module2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Telephone extends Device {
    private final String model;

    public Telephone(String series, String screenType, int price, String model) {
        super(series, screenType, price);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone: " +
                "\n  series: " + getSeries() +
                "\n  model: " + model +
                "\n  screenType: " + getScreenType() +
                "\n  price: " + getPrice() + " €\n\n";
    }
}
