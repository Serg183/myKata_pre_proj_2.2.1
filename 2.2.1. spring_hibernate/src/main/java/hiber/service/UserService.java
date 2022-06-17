package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(Object o);
    List<User> listUsers();


    List<User> getUsersCar(String model, int series);
}
