package repository;

import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryImpl implements IUsersRepository {

    List<Users> usersList = new ArrayList<>();
    BaseRepository baseRepository = new BaseRepository();

    private static final String FIND_ALL = "SELECT * FROM users";
    private static final String CREATE = "INSERT INTO users(name,email,address) " +
            " values( ? , ? , ? ) ";
    private static final String UPDATE = "UPDATE users SET name = ?, email = ?, address = ? where id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM users WHERE name like ?";
    private static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String SORT_BY_NAME = "SELECT * FROM users ORDER BY name";
    private static final String FIND_ALL_USER_SP = "call sp_find_all_user ()";
    private static final String EDIT_SP = "call sp_edit_user (?, ?, ?, ?)";
    private static final String DELETE_SP = "call sp_delete_user (?)";


    @Override
    public List<Users> findAll() {
        usersList.clear();

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                Users users = new Users(id, name, email, address);
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void createUser(Users users) {

        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getEmail());
            preparedStatement.setString(3, users.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUsers(Users users) {

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, users.getName());
            preparedStatement.setString(2, users.getEmail());
            preparedStatement.setString(3, users.getAddress());
            preparedStatement.setInt(4, users.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users findById(int id) {
        Users users = null;
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                users = new Users(name, email, address);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Users> findByName(String name) {
        usersList.clear();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String nameS = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Users users = new Users(id, nameS, email, address);
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public List<Users> sort(String name) {
        List<Users> usersList = new ArrayList<>();

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(  SORT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String nameS = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Users users = new Users(id, nameS, email, address);
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void deleteUser(int id) {

        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Users> findAllSp() {
        usersList.clear();

        try {
            Connection connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(FIND_ALL_USER_SP);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");

                Users users = new Users(id, name, email, address);
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public void updateUsersSp(Users users) {
        try {
            Connection connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(EDIT_SP);
            callableStatement.setInt(1, users.getId());
            callableStatement.setString(2, users.getName());
            callableStatement.setString(3, users.getEmail());
            callableStatement.setString(4, users.getAddress());

            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUsersSp(int id) {
        try {
            Connection connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(DELETE_SP);
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String addUsersTransaction() {
        String msg = "Ok,Transaction successfully.";
        Connection connection = baseRepository.getConnection();

        return null;
    }

}
