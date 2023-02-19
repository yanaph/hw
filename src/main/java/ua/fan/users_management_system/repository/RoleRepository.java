package ua.fan.users_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.fan.users_management_system.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
