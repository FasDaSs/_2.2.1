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

      User user = new User("User2", "Lastname2", "user2@mail.ru");
      user.setCar(new Car("Model2", 2));

      System.out.println(userService.getUserByCarModelAndSeries("Model1", 2));
      //userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      //List<User> users = userService.listUsers();
      //for (User user : users) {
      //   System.out.println("Id = "+user.getId());
      //   System.out.println("First Name = "+user.getFirstName());
      //   System.out.println("Last Name = "+user.getLastName());
      //   System.out.println("Email = "+user.getEmail());
      //   System.out.println();
      //}
      //context.close();
   }
}
