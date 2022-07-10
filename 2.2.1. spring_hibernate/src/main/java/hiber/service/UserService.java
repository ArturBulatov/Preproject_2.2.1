package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getById(Long id);
    User getByCar(String model, int series);
    List<User> listUsers();
}
