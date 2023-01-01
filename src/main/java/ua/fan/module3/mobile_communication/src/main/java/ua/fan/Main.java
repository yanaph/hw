package ua.fan;

import ua.fan.config.FlywayUtil;
import ua.fan.service.MenuService;

public class Main {
    public static void main(String[] args) {
        FlywayUtil flywayUtil = new FlywayUtil();
        flywayUtil.migrate();
        MenuService menuService = new MenuService();
        menuService.actionMenu();
    }
}
