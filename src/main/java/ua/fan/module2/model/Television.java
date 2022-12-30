package ua.fan.module2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Television extends Device {
    private final int diagonal;
    private final String country;

    public Television(String series, String screenType, int price, int diagonal, String country) {
        super(series, screenType, price);
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Television: " +
                "\n  series: " + getSeries() +
                "\n  diagonal: " + diagonal +
                "\n  screenType: " + getScreenType() +
                "\n  country: " + country +
                "\n  price: " + getPrice() + "€\n\n";
    }
}
