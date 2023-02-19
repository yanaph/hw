package ua.fan.users_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.fan.users_management_system.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    void deleteUserByEmail(String emai);
}
