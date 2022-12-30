package ua.fan.module2.service;

import ua.fan.module2.model.Device;
import ua.fan.module2.model.Invoice;
import ua.fan.module2.util.AnalyticalRequests;
import ua.fan.module2.util.FileHandling;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ua.fan.module2.Main.RANDOM;

public class ShopService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private final List<Invoice> invoices = new ArrayList<>();

    public void processInvoicesData(String fileName) {
        FileHandling fileHandling = new FileHandling();
        List<Device> catalogue = fileHandling.readFile(fileName);
        generateListOfInvoices(catalogue);
        fileHandling.writeLog(invoices);
    }

    private void generateListOfInvoices(List<Device> catalogue) {
        int number = 15;
        try {
            System.out.print("\nLet's wait a little to generate invoices with different time: ");
            for (int i = 0; i < number; i++) {
                invoices.add(generateInvoice(catalogue));
                Thread.sleep(1000);
                System.out.print(number - (i+1) +  " ");
            }
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Invoice generateInvoice(List<Device> catalogueOfDevices) {
        int number = RANDOM.nextInt(5) + 1;
        List<Device> items = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            items.add(catalogueOfDevices.get(RANDOM.nextInt(catalogueOfDevices.size())));
        }
        return new Invoice(items, PersonService.createPerson(), new Date());
    }

    public void analyticRequestsResult() {
        final AnalyticalRequests analyticalRequests = new AnalyticalRequests();

        System.out.println(ANSI_YELLOW + "Number of items sold by category:" + ANSI_RESET);
        System.out.printf("Televisions: %d %nTelephones: %d%n",
                analyticalRequests.soldAmountSortedByCategory(invoices, "Television"),
                analyticalRequests.soldAmountSortedByCategory(invoices, "Telephone"));

        System.out.println(ANSI_YELLOW + "\nCustomer info of invoice with minimum total price:" + ANSI_RESET);
        System.out.printf("Minimum total: %d %nCustomer:", analyticalRequests.minSumInvoiceInfo(invoices).getTotalPrice());
        System.out.println(analyticalRequests.minSumInvoiceInfo(invoices).getCustomer());

        System.out.printf(ANSI_YELLOW + "\nTotal price of all invoices: " + ANSI_RESET + "%d%n",
                analyticalRequests.getTotalPriceOfAllInvoices(invoices));

        System.out.printf(ANSI_YELLOW + "\nNumber of invoices with retail type: " + ANSI_RESET + "%d%n",
                analyticalRequests.getRetailInvoicesNumber(invoices));

        System.out.println(ANSI_YELLOW + "\nInvoices that contain only one type of devices:\n" + ANSI_RESET +
                analyticalRequests.getOneDeviceTypeInvoices(invoices));

        System.out.println(ANSI_YELLOW + "\nFirst three invoices:\n" + ANSI_RESET +
                analyticalRequests.getFirstThreeInvoices(invoices));

        System.out.println(ANSI_YELLOW + "Low age invoices:\n" + ANSI_RESET +
                analyticalRequests.getLowAgeInvoices(invoices));

        System.out.println(ANSI_YELLOW + "Sorting invoices by condition:\n" + ANSI_RESET +
                analyticalRequests.sortInvoicesByTotalPrice(invoices));
    }
}
