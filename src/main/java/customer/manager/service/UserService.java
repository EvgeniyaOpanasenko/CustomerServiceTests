package customer.manager.service;


import customer.manager.model.Customer;
import customer.manager.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    User getByName(String name);
    List<User> getAll();

}
