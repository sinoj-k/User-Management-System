package com.UMS.Service;

import com.UMS.Model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel model);

    List<UserModel> addUsers(List<UserModel> model);

    UserModel getUser(Long id);

    List<UserModel> getAllUsers();

    UserModel updateUser(Long id, UserModel model);

    void deleteUser(Long id);

}
