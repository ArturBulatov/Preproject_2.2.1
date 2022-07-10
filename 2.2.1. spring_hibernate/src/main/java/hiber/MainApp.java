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
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Mark", "Walberg", "father_stu@mail.ru",new Car("BMW", 6)));
      userService.add(new User("Ann", "Hathaway", "deval_prado@mail.ru",new Car("Audi", 4)));
      userService.add(new User("Adam", "Sandler", "hustle@mail.ru",new Car("Tesla", 3)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Model of car = "+user.getCar().getModel());
         System.out.println("Car series = "+user.getCar().getSeries());
         System.out.println("==================");
         System.out.println();
      }


//      System.out.println(userService.getById(1L));
      System.out.println(userService.getByCar("Audi", 4));

      context.close();
   }
}
