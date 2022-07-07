package repository.class_repository.employee;

import model.employee.Employee;
import repository.BaseRepository;
import repository.interface_repository.employee.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    List<Employee> employeeList = new ArrayList<>();

    private static final String FIND_ALL = "select * from employee";
    private static final String CREATE_EMPLOYEE = "insert into employee(`name`,date_of_birth,id_card,salary," +
            "phone_number,email,address,position_id,division_id,education_degree_id,username)" +
            " values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String FIND_BY_ID = "select * from employee where id = ?";
    private static final String EDIT_EMPLOYEE = "update employee set `name` = ?,date_of_birth = ?, id_card = ?, " +
            " salary = ?, phone_number = ?, email = ?, address = ?, position_id = ?, division_id = ?, education_degree_id = ? where id = ?";

    private static final String DELETE_EMPLOYEE = "delete from employee where id = ?";
    private static final String FIND_EMPLOYEE = "select * from employee where name like ? and email like ? and address like ?";

    @Override
    public List<Employee> findAll() {
        employeeList.clear();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = Double.parseDouble(resultSet.getString("salary"));
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int idPosition = resultSet.getInt("position_id");
                int idDivision = resultSet.getInt("division_id");
                int idEducation = resultSet.getInt("education_degree_id");
                String user = resultSet.getString("username");

                Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, idPosition, idDivision, idEducation, user);

                employeeList.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void createEmployee(Employee employee) {

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getNameEmployee());
            preparedStatement.setString(2, employee.getDayOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setInt(4, (int) employee.getSalary());
            preparedStatement.setString(5, employee.getNumberPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getDivisionId());
            preparedStatement.setInt(10, employee.getEducationDegreeId());
            preparedStatement.setString(11, employee.getUserName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editEmployee(Employee employee) {

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_EMPLOYEE);
            preparedStatement.setString(1, employee.getNameEmployee());
            preparedStatement.setString(2, employee.getDayOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setInt(4, (int) employee.getSalary());
            preparedStatement.setString(5, employee.getNumberPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getDivisionId());
            preparedStatement.setInt(10, employee.getEducationDegreeId());
            preparedStatement.setInt(11, employee.getIdEmployee());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idS = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String dayOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = Double.parseDouble(resultSet.getString("salary"));
                String numberPhone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int position = Integer.parseInt(resultSet.getString("position_id"));
                int division = Integer.parseInt(resultSet.getString("division_id"));
                int education = Integer.parseInt(resultSet.getString("education_degree_id"));

                employee = new Employee(idS, name, dayOfBirth, idCard, salary, numberPhone, email, address, position, division, education);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployee(String name, String email, String address) {
        employeeList.clear();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + email + "%");
            preparedStatement.setString(3, "%" + address + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idS = Integer.parseInt(resultSet.getString("id"));
                String nameS = resultSet.getString("name");
                String dayOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = Double.parseDouble(resultSet.getString("salary"));
                String numberPhone = resultSet.getString("phone_number");
                String emailS = resultSet.getString("email");
                String addressS = resultSet.getString("address");
                int position = Integer.parseInt(resultSet.getString("position_id"));
                int division = Integer.parseInt(resultSet.getString("division_id"));
                int education = Integer.parseInt(resultSet.getString("education_degree_id"));

                Employee employee = new Employee(idS, nameS, dayOfBirth, idCard, salary, numberPhone, emailS, addressS, position, division, education);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}
