package com.notwallas.segundaApi.repository;

import java.util.ArrayList;
import java.util.List;
import com.notwallas.segundaApi.entity.User;

public class UserRepository {
    // Lista privada para almacenar los usuarios en memoria
    private static List<User> users = new ArrayList<>();


    public void saveUser(User user) {
        users.add(user);
    }

    public User findUserById(int id) {
        // Buscar usuario por ID
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(users);
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
