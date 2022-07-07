package service.interface_service.customer;

import model.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void createCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer findById(int id);

    List<Customer> findCustomer(String name,String email, String type);

}
