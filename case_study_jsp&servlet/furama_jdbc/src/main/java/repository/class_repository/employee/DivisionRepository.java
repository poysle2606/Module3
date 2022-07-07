package repository.class_repository.employee;

import model.employee.DivisionEmployee;
import repository.BaseRepository;
import repository.interface_repository.employee.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    BaseRepository baseRepository = new BaseRepository();
    List<DivisionEmployee> employeeList = new ArrayList<>();
    private static final String FIND_ALL = "select * from division";

    @Override
    public List<DivisionEmployee> listDivision() {
        employeeList.clear();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                DivisionEmployee divisionEmployee = new DivisionEmployee(id,name);
                employeeList.add(divisionEmployee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
