package repository.class_repository.employee;

import model.employee.PositionEmployee;
import repository.BaseRepository;
import repository.interface_repository.employee.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    BaseRepository baseRepository = new BaseRepository();
    List<PositionEmployee> employeeList = new ArrayList<>();
    private static final String FIND_ALL = "select * from position";

    @Override
    public List<PositionEmployee> listPosition() {
        employeeList.clear();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                PositionEmployee positionEmployee = new PositionEmployee(id,name);
                employeeList.add(positionEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
