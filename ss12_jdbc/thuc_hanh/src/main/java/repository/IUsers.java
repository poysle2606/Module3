package repository;

import model.Users;

import java.sql.SQLException;
import java.util.List;

public interface IUsers {
    void insertUser(Users user) throws SQLException;

    Users selectUser(int id);

    List<Users> selectAllUsers();

    boolean deleteUsers(int id) throws SQLException;

    boolean updateUsers(Users user) throws SQLException;

}
