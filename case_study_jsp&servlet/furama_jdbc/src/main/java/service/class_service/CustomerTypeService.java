package service.class_service;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.class_repository.CustomerTypeRepository;
import repository.interface_repository.ICustomerTypeRepository;
import service.interface_service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    ICustomerTypeRepository repository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> listCustomer() {
        return repository.listCustomer();
    }
}
