package ua.fan.module2;

import ua.fan.module2.model.Invoice;
import ua.fan.module2.service.ShopService;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final Random RANDOM = new Random();
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Enter limit for wholesale shopping: ");
        final Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()){
            Invoice.setLimit(scanner.nextInt());
            ShopService shopService = new ShopService();
            shopService.processInvoicesData("catalogue.csv");
            shopService.analyticRequestsResult();
        } else {
            System.out.println("Limit value is not valid!");
        }
        scanner.close();
    }
}
