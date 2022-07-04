package service.interface_service;

import model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void createCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(int id);
}
