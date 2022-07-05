package repository.interface_repository.employee;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAll();

    void createEmployee(Employee employee);

    void editEmployee(Employee employee);

    void deleteEmployee(int id);

    Employee findById(int id);
}
