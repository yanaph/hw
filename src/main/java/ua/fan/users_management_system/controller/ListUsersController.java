package ua.fan.users_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.fan.users_management_system.dto.UserDto;
import ua.fan.users_management_system.service.UserService;

import java.util.List;

@Controller
public class ListUsersController {
    private UserService userService;

    @Autowired
    public ListUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }
}
