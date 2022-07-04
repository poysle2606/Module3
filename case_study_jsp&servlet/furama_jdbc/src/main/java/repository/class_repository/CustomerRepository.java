package repository.class_repository;

import model.customer.Customer;
import repository.BaseRepository;
import repository.interface_repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    List<Customer> customerList = new ArrayList<>();
    BaseRepository baseRepository = new BaseRepository();

    private static final String FIND_ALL = "select * from customer";
    private static final String ADD_CUSTOMER = "insert into customer(customer_type_id,`name`,date_of_birth,gender,id_card,phone_number,email,address) " +
            " values(?,?,?,?,?,?,?,?)";

    @Override
    public List<Customer> findAll() {
        customerList.clear();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("name");
                String dayOfBirth = resultSet.getString("date_of_birth");
                int gender = resultSet.getInt("gender");
                String idCard = resultSet.getString("id_card");
                String numberPhone = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                Customer customer = new Customer(id, customerTypeId, name, dayOfBirth, gender, idCard, numberPhone, email, address);

                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void createCustomer(Customer customer) {

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER);
            preparedStatement.setInt(1, customer.getIdTypeCustomer());
            preparedStatement.setString(2, customer.getNameCustomer());
            preparedStatement.setString(3, customer.getDayOfBirth());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getId_card());
            preparedStatement.setString(6, customer.getNumberPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(int id) {

    }
}
