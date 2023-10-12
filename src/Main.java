import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        FileWriter fileWriter;


        System.out.println("add user to list? y/n");
        User user = new User();
        while (scanner.nextLine().equals("y")) {
            System.out.println("Print down User Name");
            user.setName(scanner.nextLine());
            System.out.println("print down email");
            String email = scanner.nextLine();
            if (user.setEmail(email)) {
                users.add(user);
                try {
                    fileWriter = new FileWriter("data");
                    fileWriter.write(user.toString());
                    fileWriter.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("add user to list? y/n");
        }
        System.out.println("print users:");
        if (users.size() > 0) {
            users.forEach(System.out::println);
        }

    }

}