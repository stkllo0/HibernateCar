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

        User user1 = new User("Oleg", "Petrov", "Ol@mail.ru");
        user1.setCar(new Car("Toyota", 560));
        userService.add(user1);

        User user2 = new User("Katya", "Tuzova", "zov@mail.ru");
        user2.setCar(new Car("BMW", 667));
        userService.add(user2);

        context.close();
    }
}
