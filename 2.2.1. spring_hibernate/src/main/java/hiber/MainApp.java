package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      User user = new User("User1", "Lastname1", "user1@mail.ru");
      user.setCar(new Car("Model1", 1));
      userService.add(user);

      user = new User("User2", "Lastname2", "user2@mail.ru");
      user.setCar(new Car("Model1", 2));
      userService.add(user);

      user = new User("User3", "Lastname3", "user3@mail.ru");
      user.setCar(new Car("Model2", 1));
      userService.add(user);

      user = new User("User4", "Lastname4", "user4@mail.ru");
      user.setCar(new Car("Model3", 3));
      userService.add(user);

      List<User> users = userService.listUsers();
      users.forEach(System.out::println);
      System.out.println();

      System.out.println(userService.getUserByCarModelAndSeries("Model5", 2));

      context.close();
   }
}
