package service.class_service.employee;

import model.employee.Employee;
import repository.class_repository.employee.EmployeeRepository;
import repository.interface_repository.employee.IEmployeeRepository;
import service.interface_service.employee.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.createEmployee(employee);
    }

    @Override
    public void editEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public Employee findById(int id) {
        return null;
    }
}
