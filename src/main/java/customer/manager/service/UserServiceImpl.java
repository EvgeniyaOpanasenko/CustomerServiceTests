package customer.manager.service;

import customer.manager.model.Customer;
import customer.manager.model.User;
import customer.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public User getByName(String name) {
        return getAll().stream()
                .filter(user -> user.getName().equals(name)).findFirst().get();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
