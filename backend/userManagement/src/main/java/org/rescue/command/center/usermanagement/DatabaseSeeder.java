package org.rescue.command.center.usermanagement;

import org.rescue.command.center.usermanagement.enums.RoleType;
import org.rescue.command.center.usermanagement.model.Role;
import org.rescue.command.center.usermanagement.model.User;
import org.rescue.command.center.usermanagement.repository.RoleRepository;
import org.rescue.command.center.usermanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    public DatabaseSeeder(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createInitialData();
    }

    private void createInitialData(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        List<User> users = userRepository.findByUsername("johndoe");

        if (!users.isEmpty()) {
            return;
        }

        User user1 = new User("johndoe", "John", "Doe",encoder.encode("Password123!"));
        User user2 = new User("janedoe", "Jane", "Doe",encoder.encode("Password123!"));

        userRepository.save(user1);
        userRepository.save(user2);

        Role role1 = new Role(RoleType.USER);
        Role role2 = new Role(RoleType.ADMIN);

        roleRepository.save(role1);
        roleRepository.save(role2);

        Role roleUser = roleRepository.findByName(RoleType.USER);
        Role roleAdmin = roleRepository.findByName(RoleType.ADMIN);

        User user_1 = userRepository.findById(user1.getId()).orElseThrow();
        User user_2 = userRepository.findById(user2.getId()).orElseThrow();

        user_1.addRole(roleAdmin);
        user_1.addRole(roleUser);
        user_2.addRole(roleUser);

        userRepository.save(user_1);
        userRepository.save(user_2);
    }
}