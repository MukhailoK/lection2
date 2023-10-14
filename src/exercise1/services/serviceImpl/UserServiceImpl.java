package exercise1.services.serviceImpl;

import exercise1.model.User;
import exercise1.repositories.CrudRepository;
import exercise1.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private CrudRepository crudRepository;

    public UserServiceImpl(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public List<User> findAllByName(String name) {
        List<User> users = crudRepository.findAll();
        List<User> usersWithSameName = new ArrayList<>();
        for (User user : users) {
            if (user.getName().equals(name)) {
                usersWithSameName.add(user);
            }
        }
        return usersWithSameName;
    }

    public boolean add(User user) {
        List<User> userFromRepo = crudRepository.findAll();
        if (userFromRepo != null) {
            for (User u : userFromRepo) {
                if (u.getEmail().equals(user.getEmail())) {
                    System.out.println("email must be uniq");
                    return false;
                }
            }
        }
        if (user.getName() != null && user.getEmail() != null) {
            crudRepository.save(user);
            return true;
        }
        return false;
    }

    public List<User> getAllUsers() {
        List<User> users = crudRepository.findAll();
        return users.size() > 0 ? users : null;
    }
}
