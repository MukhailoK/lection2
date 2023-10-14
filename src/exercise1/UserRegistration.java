package exercise1;

import exercise1.model.User;
import exercise1.repositories.CrudRepository;
import exercise1.repositories.UserRepositoryFileImpl;
import exercise1.services.UserService;
import exercise1.services.serviceImpl.UserServiceImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserRegistration {
    private static final String EMAIL_PATTERN = "^(.+)@(\\S+)$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CrudRepository repository = new UserRepositoryFileImpl("users.txt");
        UserService userService = new UserServiceImpl(repository);

        while (true) {
            System.out.print("Enter name (or 'exit' to quit): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            // Email validation
            String email = null;
            while (true) {
                System.out.print("Enter email: ");
                email = scanner.nextLine();

                if (isValidEmail(email)) {
                    break;
                } else {
                    System.out.println("Email must contain the '@' symbol. Please enter a valid email.");
                }
            }

            User user = new User(name, email);
            userService.add(user);
        }
        List<User> users = userService.getAllUsers();
        System.out.println("Get all users:");
        users.forEach(System.out::println);
        users = userService.findAllByName("user");
        System.out.println("get all users with name 'user':");
        users.forEach(System.out::println);
        //saveUsersToFile(users, "src/users.txt");

//        System.out.println(repository.findAll());
    }

    private static void saveUsersToFile(List<User> users, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.write(user.getName() + " " + user.getEmail());
                writer.newLine(); // Move to a new line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidEmail(String email) {

        return email != null && email.matches(EMAIL_PATTERN);
    }
}
