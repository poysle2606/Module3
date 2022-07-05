package service.class_service.customer;

import model.customer.Customer;
import repository.class_repository.customer.CustomerRepository;
import repository.interface_repository.customer.ICustomerRepository;
import service.interface_service.customer.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.createCustomer(customer);
    }

    @Override
    public void editCustomer(Customer customer) {
        iCustomerRepository.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

}
