package repository.interface_repository.customer;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void createCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(int id);

    Customer findById(int id);

    List<Customer> findCustomer(String name,String email, String type);



}
