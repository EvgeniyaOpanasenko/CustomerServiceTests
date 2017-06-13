package customer.manager.controller;

import customer.manager.model.User;
import customer.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value="/users", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<User> getItems() {
        return service.getAll();
    }

    @RequestMapping(value = "/getUser{name}", method = RequestMethod.GET)
    public User getByName(@PathVariable("name") String name) {
        return service.getByName(name);
    }

    @RequestMapping(value = "/create{name}",method = RequestMethod.POST)
    public void add(@PathVariable String name) {
        /*User model = new User();
        model.setName(user.getName());*/
        service.create(new User(name));
    }
}
