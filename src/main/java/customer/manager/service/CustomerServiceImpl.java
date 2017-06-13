package customer.manager.service;

import customer.manager.model.Customer;
import customer.manager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public void create(Customer customer) {
         repository.save(customer);
    }

    @Override
    public Customer getIteById(long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer getByName(String name) {

        return repository.findAll().stream()
                .filter(customer -> customer.getName()
                        .equals(name)).findFirst().get();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return getAllCustomer().stream()
                .filter(customer1 -> customer1.getId() == customer.getId())
                                                                    .findFirst().get();
    }
}
