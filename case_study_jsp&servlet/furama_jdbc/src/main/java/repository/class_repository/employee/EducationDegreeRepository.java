package repository.class_repository.employee;

import model.employee.EducationDegree;
import repository.BaseRepository;
import repository.interface_repository.employee.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String FIND_ALL = "select * from education_degree";
    @Override
    public List<EducationDegree> educationList() {
        List<EducationDegree> degreeList = new ArrayList<>();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                EducationDegree educationDegree = new EducationDegree(id,name);
                degreeList.add(educationDegree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return degreeList;
    }
}
