package ua.fan.module2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private final long id;
    private final String email;
    private final int age;

    @Override
    public String toString() {
        return "id: " + id +
                "\nemail: " + email +
                "\nage: " + age;
    }
}
