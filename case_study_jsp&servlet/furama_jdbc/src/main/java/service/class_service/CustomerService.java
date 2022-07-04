package service.class_service;

import model.customer.Customer;
import repository.class_repository.CustomerRepository;
import repository.interface_repository.ICustomerRepository;
import service.interface_service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.editCustomer(customer);
    }

    @Override
    public void editCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }
}
