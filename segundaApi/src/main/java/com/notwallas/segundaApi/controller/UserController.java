package com.notwallas.segundaApi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notwallas.segundaApi.entity.User;
import com.notwallas.segundaApi.service.UserService;



@RestController
@RequestMapping("/api/users") // Define the base route for user-related requests
public class UserController {
    // This method handles GET requests to the /api/users/create endpoint

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
        UserService userService = new UserService();
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
        UserService userService = new UserService();
        return userService.GetAllUsers(); // devuelve la cadena con usuarios
    }


    @GetMapping("/get/{id}")
    public String getUserById(@PathVariable int id) {
        UserService userService = new UserService();
        User user = userService.GetUserById(id);  // recupera el usuario

        if (user != null) {
            return user.toString();  // muestra sus datos
        } else {
            return "Usuario con ID " + id + " no encontrado.";
        }
    }


    @PutMapping("/update/{id}/{name}/{age}/{email}/{password}/{carrer}")
    public String updateUser(
        @PathVariable int id, 
        @PathVariable String name, 
        @PathVariable int age, 
        @PathVariable String email, 
        @PathVariable String password, 
        @PathVariable String carrer) {
        
        UserService userService = new UserService();
        boolean updated = userService.UpdateUser(id, name, age, email, password, carrer);

        if (updated) {
            return "Usuario actualizado correctamente.";
        } else {
            return "Usuario con ID " + id + " no encontrado.";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        // Delete a user by ID using the UserService
        UserService userService = new UserService();
        userService.DeleteUser(id);
        // Return a success message
        return "User deleted successfully!";
    }

}