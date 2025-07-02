package com.notwallas.segundaApi.entity;

public class User {
    private String name;
    private int age;
    private String email;
    private String password;
    private String carrera;

    private int id;
    private static int idCounter = 0;

// Constructor
    public User(String name, int age, String email, String password, String carrera) {
        assignAutoId();
        setName(name);
        setAge(age);
        setEmail(email);
        setPassword(password);
        setCarrer(carrera);
    }

    // Getters y Setters
    
    public void assignAutoId() {
        this.id = ++idCounter;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setCarrer(String carrera) {
        this.carrera = carrera;
    }


    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCarrer() {
        return carrera;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", carrer='" + carrera + '\'' +
                '}';
    }

}