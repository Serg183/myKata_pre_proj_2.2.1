package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("user1", "aaaaa", "user1@mail.ru");
      User user2 = new User("user2", "bbbbbb", "user2@mail.ru");
      User user3 = new User("user3", "cccccc", "user3@mail.ru");
      User user4 = new User("user4", "ddddd", "user4@mail.ru");

      Car car1 = new Car("car1", 111, user1);
      Car car2 = new Car("car2", 222, user2);
      Car car3 = new Car("car3", 333, user3);
      Car car4 = new Car("car4", 555, user4);

      userService.add(user1.setCar(car1));
      userService.add(user2.setCar(car2));
      userService.add(user3.setCar(car3));
      userService.add(user4.setCar(car4));


      List<User> users = userService.getUsersCar("car3", 333);
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }

      context.close();
   }
}
