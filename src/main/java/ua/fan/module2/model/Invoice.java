package ua.fan.module2.model;

import lombok.Getter;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;

import static ua.fan.module2.model.InvoiceType.*;

@Getter
public class Invoice {
    private static int limit;
    private final List<Device> items;
    private final Customer customer;
    private final Date dateTime;
    private InvoiceType type;

    public Invoice(List<Device> items, Customer customer, Date dateTime) {
        this.items = items;
        this.customer = customer;
        this.dateTime = dateTime;
        setInvoiceType();
    }

    private void setInvoiceType() {
        if (getTotalPrice() > limit) {
            type = WHOLE_SALE;
        } else {
            type = RETAIL;
        }
    }

    public void setType(InvoiceType type) {
        this.type = type;
    }

    public static void setLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit can't be less than 0");
        }
        Invoice.limit = limit;
    }

    @Override
    public String toString() {
        return "DATE: " + dateTime +
                "\nCUSTOMER: \n" + customer +
                "\nINVOICE TYPE: " + type +
                "\nITEMS: \n " +
                items.stream()
                        .map(Device::toString)
                        .collect(Collectors.joining(" "));
    }

    public int getTotalPrice() {
        return items.stream()
                .mapToInt(Device::getPrice)
                .sum();
    }

    public int getAmountOfItems() {
        return items.size();
    }
}
