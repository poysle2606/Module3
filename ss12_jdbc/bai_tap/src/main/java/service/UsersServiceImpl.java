package service;

import model.Users;
import repository.IUsersRepository;
import repository.UsersRepositoryImpl;

import java.util.List;

public class UsersServiceImpl implements IUsersService {
    IUsersRepository usersRepository = new UsersRepositoryImpl();

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public void createUser(Users users) {
        usersRepository.createUser(users);
    }

    @Override
    public void editUsers(Users users) {
        usersRepository.editUsers(users);
    }

    @Override
    public void deleteUser(int id) {
        usersRepository.deleteUser(id);
    }

    @Override
    public Users findById(int id) {
        return usersRepository.findById(id);
    }

    @Override
    public List<Users> findByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public List<Users> sort(String name) {
        return usersRepository.sort(name);
    }

    @Override
    public List<Users> findAllSp() {
        return usersRepository.findAllSp();
    }

    @Override
    public void updateUsersSp(Users users) {
        usersRepository.updateUsersSp(users);

    }

    @Override
    public void deleteUsersSp(int id) {
        usersRepository.deleteUsersSp(id);
    }

    @Override
    public String addUsersTransaction() {
        return usersRepository.addUsersTransaction();
    }
}
