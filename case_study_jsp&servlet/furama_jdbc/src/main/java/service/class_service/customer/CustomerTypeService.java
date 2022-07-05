package service.class_service.customer;

import model.customer.CustomerType;
import repository.class_repository.customer.CustomerTypeRepository;
import repository.interface_repository.customer.ICustomerTypeRepository;
import service.interface_service.customer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    ICustomerTypeRepository repository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> listCustomer() {
        return repository.listCustomer();
    }
}
