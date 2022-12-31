package ua.fan.service;

import ua.fan.dao.ActivityDao;
import ua.fan.dao.ActivityTypeDao;
import ua.fan.dao.DeviceDao;
import ua.fan.dao.SubscriberDao;
import ua.fan.entity.Activity;

import java.util.List;
import java.util.Scanner;

public class MenuService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ActivityDao ACTIVITY_DAO = new ActivityDao();
    private static final ActivityTypeDao ACTIVITY_TYPE_DAO = new ActivityTypeDao();
    private static final DeviceDao DEVICE_DAO = new DeviceDao();
    private static final SubscriberDao SUBSCRIBER_DAO = new SubscriberDao();

    public void actionMenu() {
        final String[] menuActions = new String[MenuActions.values().length];
        for (int i = 0; i < menuActions.length; i++) {
            menuActions[i] = MenuActions.values()[i].getName();
        }
        int choice;
        do {
            System.out.println("\n\nInput a number to view information:");
            for (int i = 0; i < menuActions.length; i++) {
                System.out.printf("%d) %s%n", i + 1, menuActions[i]);
            }
            choice = SCANNER.nextInt();
            switch (choice) {
                case 1 -> searchSMSbyPhrase();
                case 2 -> topSubscribersByCalls();
                case 3 -> topSubscribersBySMS();
                case 4 -> topSubscribersByInternet();
                case 5 -> mostPopularService();
                case 6 -> mostPopularDevice();
            }
        } while (choice > 0 && choice < menuActions.length);
        SCANNER.close();

    }

    private void mostPopularDevice() {
        System.out.println("Most popular device model among subscribers:");
        List<Object[]> activity = DEVICE_DAO.getMostPopularDevice();
        printInfo(activity);
    }

    private void mostPopularService() {
        System.out.println("Most popular service among subscribers:");
        List<Object[]> activity = ACTIVITY_TYPE_DAO.getMostPopularActivity();
        printInfo(activity);
    }

    private void topSubscribersByInternet() {
        System.out.println("TOP 5 subscribers by internet searches number");
        List<Object[]> subscribers = SUBSCRIBER_DAO.getTop5SubscribersByInternet();
        printInfo(subscribers);
    }

    private void topSubscribersBySMS() {
        System.out.println("TOP 5 subscribers by SMS number");
        List<Object[]> subscribers = SUBSCRIBER_DAO.getTop5SubscribersBySMS();
        printInfo(subscribers);
    }

    private void topSubscribersByCalls() {
        System.out.println("TOP 5 subscribers by call number");
        List<Object[]> subscribers = SUBSCRIBER_DAO.getTop5SubscribersByCall();
        printInfo(subscribers);
    }

    private void searchSMSbyPhrase() {
        System.out.println("Enter phrase by which you want to find SMS:");
        String phrase = SCANNER.nextLine();
        List<Activity> SMSyByText = ACTIVITY_DAO.getSMSyByText(phrase);
        if (!SMSyByText.isEmpty()){
            for (Activity activity : SMSyByText) {
                System.out.println(activity);
            }
        } else {
            System.out.println("Unfortunately, no SMS were found with '" + phrase + "'");
        }
    }

    public void printInfo(List<Object[]> information){
        for (Object[] info : information) {
            System.out.printf("%s: %s%n", info[0], info[1]);
        }
    }
}
