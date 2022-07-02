package repository;

import model.Users;

import java.util.List;

public interface IUsersRepository {
    List<Users> findAll();

    void createUser(Users users);

    void editUsers(Users users);

    void deleteUser(int id);

    Users findById(int id);

    List<Users> findByName(String name);

    List<Users> sort(String name);

    List<Users> findAllSp();

    void updateUsersSp(Users users);

    void deleteUsersSp(int id);

    String addUsersTransaction();
}
