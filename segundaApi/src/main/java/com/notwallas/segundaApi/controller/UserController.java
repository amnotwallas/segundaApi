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
    /**
     * Endpoint to check if the API is running.
     * @return a simple string message.
     */
    @GetMapping("/ping")
    public String ping() {
        return "API funcionando!";
    }

    /**
     * * Endpoint for creating a user.
     * @param edad its the age of the user.
     * @param nombre its the name of the user.
     * @param email its the email of the user.
     * @param password its the password of the user.
     * @param carrera its the career of the user.
     * @return a string with the user details.
     **/
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

    /**
     * Endpoint to get all users.
     * @return a string with all users.
     */
    @GetMapping("/getAll")
    public String getAllUsers() {
        return userService.GetAllUsers();
    }

    /**
     * Endpoint to get a user by ID.
     * @param id the ID of the user.
     * @return a string with the user details or an error message.
     */
    @GetMapping("/get/{id}")
    public String getUserById(@PathVariable int id) {
        User user = userService.GetUserById(id);
        if (user != null) {
            return user.toString();
        } else {
            return "Usuario con ID " + id + " no encontrado.";
        }
    }

    /**
     * Endpoint to update a user by ID.
     * @param id the ID of the user.
     * @param name the new name of the user.
     * @param age the new age of the user.
     * @param email the new email of the user.
     * @param password the new password of the user.
     * @param carrer the new career of the user.
     * @return a string with a success message or an error message.
     */
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

    /**
     * Endpoint to delete a user by ID.
     * @param id the ID of the user to delete.
     * @return a string with a success message.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.DeleteUser(id);
        return "User deleted successfully!";
    }
}
