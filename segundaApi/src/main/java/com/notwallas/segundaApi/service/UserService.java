package com.notwallas.segundaApi.service;
import com.notwallas.segundaApi.entity.User;
import com.notwallas.segundaApi.repository.UserRepository;


public class UserService {
    public User CreateUser(String nombre, int edad, String email, String password, String carrera) {
        User user = new User(nombre, edad, email, password, carrera);
        UserRepository userRepository = new UserRepository();
        userRepository.saveUser(user);
        return user;
    }

    public String GetAllUsers() {
        String allUsers = "";
        UserRepository userRepository = new UserRepository();
        for (User user : userRepository.findAllUsers()) {
            allUsers += "ID: " + user.getId() + ", Name: " + user.getName() + 
                        ", Age: " + user.getAge() + ", Email: " + user.getEmail() + 
                        ", Carrera: " + user.getCarrer() + "\n";
        }
        return allUsers.toString();
    }

    public User GetUserById(int id) {
        UserRepository userRepository = new UserRepository();
        return userRepository.findUserById(id);
    }

    public boolean UpdateUser(int id, String name, int age, String email, String password, String carrer) {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findUserById(id);
        if (user != null) {
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            user.setPassword(password);
            user.setCarrer(carrer);
            return true;
        } else {
            return false;
        }
    }


    public void DeleteUser(int id) {
        UserRepository userRepository = new UserRepository();
        userRepository.deleteUser(id);
        System.out.println("User deleted with ID: " + id);
    }
}
