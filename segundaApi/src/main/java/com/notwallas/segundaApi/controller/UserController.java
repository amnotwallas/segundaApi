package com.notwallas.segundaApi.controller;

import com.notwallas.segundaApi.entity.User;
import com.notwallas.segundaApi.repository.UserRepository;
import com.notwallas.segundaApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired // Spring inyecta el UserRepository aquí y se lo pasa al UserService
    public UserController(UserRepository userRepository) {
        this.userService = new UserService(userRepository);
    }

    @GetMapping("/ping")
    public String ping() {
        return "API funcionando!";
    }

    @PostMapping("/create/{nombre}/{edad}/{email}/{password}/{carrera}")
    public String createUser(@PathVariable String nombre,
                             @PathVariable int edad,
                             @PathVariable String email,
                             @PathVariable String password,
                             @PathVariable String carrera) {
        User user = userService.CreateUser(nombre, edad, email, password, carrera);
        return "Usuario creado:\n" +
                "ID: " + user.getId() + "\n" +
                "Nombre: " + user.getName() + "\n" +
                "Edad: " + user.getAge() + "\n" +
                "Email: " + user.getEmail() + "\n" +
                "Carrera: " + user.getCarrer();
    }

    @GetMapping("/getAll")
    public String getAllUsers() {
        return userService.GetAllUsers();
    }

    @GetMapping("/get/{id}")
    public String getUserById(@PathVariable int id) {
        User user = userService.GetUserById(id);
        if (user != null) {
            return user.toString();
        } else {
            return "Usuario con ID " + id + " no encontrado.";
        }
    }

    @PutMapping("/update/{id}/{name}/{age}/{email}/{password}/{carrer}")
    public String updateUser(@PathVariable int id,
                             @PathVariable String name,
                             @PathVariable int age,
                             @PathVariable String email,
                             @PathVariable String password,
                             @PathVariable String carrer) {
        boolean updated = userService.UpdateUser(id, name, age, email, password, carrer);
        return updated ? "Usuario actualizado correctamente." : "Usuario con ID " + id + " no encontrado.";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.DeleteUser(id);
        return "User deleted successfully!";
    }
}
