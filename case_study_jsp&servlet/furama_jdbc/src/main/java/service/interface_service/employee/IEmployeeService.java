package service.interface_service.employee;

import model.customer.Customer;
import model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void createEmployee(Employee employee);

    void editEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee findById(int id);

    List<Employee> findEmployee(String name, String email, String address);
}
