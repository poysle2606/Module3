package repository.class_repository.customer;

import model.customer.CustomerType;
import repository.BaseRepository;
import repository.interface_repository.customer.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {

    BaseRepository baseRepository = new BaseRepository();
    private static final String FIND_ALL_TYPE = "select * from customer_type";
    @Override
    public List<CustomerType> listCustomer() {
        List<CustomerType> customerList = new ArrayList<>();

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                CustomerType customerType = new CustomerType(id,name);
                customerList.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
