package com.notwallas.segundaApi.repository;

import com.notwallas.segundaApi.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void saveUser_shouldAddUserToList() {
        User user = new User("Juan", 25, "juan@mail.com", "1234", "Sistemas");
        userRepository.saveUser(user);

        User result = userRepository.findUserById(user.getId());
        assertNotNull(result);
        assertEquals("Juan", result.getName());
    }

    @Test
    void findUserById_shouldReturnCorrectUser() {
        User user = new User("Ana", 30, "ana@mail.com", "abcd", "Industrial");
        userRepository.saveUser(user);

        User result = userRepository.findUserById(user.getId());
        assertEquals("Ana", result.getName());
    }

    @Test
    void findAllUsers_shouldReturnAllUsers() {
        userRepository.saveUser(new User("Juan", 25, "juan@mail.com", "1234", "Sistemas"));
        userRepository.saveUser(new User("Ana", 30, "ana@mail.com", "abcd", "Industrial"));

        List<User> users = userRepository.findAllUsers();
        assertEquals(2, users.size());
    }

    @Test
    void deleteUser_shouldRemoveUserById() {
        User user = new User("Juan", 25, "juan@mail.com", "1234", "Sistemas");
        userRepository.saveUser(user);

        userRepository.deleteUser(user.getId());

        assertNull(userRepository.findUserById(user.getId()));
    }
}
