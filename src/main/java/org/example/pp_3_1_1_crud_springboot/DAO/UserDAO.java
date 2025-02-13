package org.example.pp_3_1_1_crud_springboot.DAO;

import org.example.pp_3_1_1_crud_springboot.model.User;

import java.util.List;

public interface UserDAO {

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> getAllUsers();

    User getUserById(long id);

}
