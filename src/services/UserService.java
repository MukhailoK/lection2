package services;

import model.User;

import java.util.List;

public interface UserService {
     List<User> findAllByName(String name);
     boolean add(User user);

     List<User> getAllUsers();
}
