package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(Object o);

   List<User> listUsers();

   List<User> getUsersCar(String model, int series);

}
