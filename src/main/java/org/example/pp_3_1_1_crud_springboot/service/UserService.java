package org.example.pp_3_1_1_crud_springboot.service;

import org.example.pp_3_1_1_crud_springboot.model.User;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserService {
    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> getAllUsers();

    User getUserById(long id);
}
