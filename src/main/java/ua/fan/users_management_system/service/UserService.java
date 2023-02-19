package ua.fan.users_management_system.service;

import ua.fan.users_management_system.dto.UserDto;
import ua.fan.users_management_system.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    void updateUsersPassword(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
