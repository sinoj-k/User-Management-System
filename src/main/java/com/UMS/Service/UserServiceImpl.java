package com.UMS.Service;

import com.UMS.Exception.UserNotFoundException;
import com.UMS.Model.UserModel;
import com.UMS.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserModel addUser(UserModel model) {
        return userRepository.save(model);
    }

    @Override
    public UserModel getUser(Long id) {
        return userRepository.findById(id).orElseThrow (()->new UserNotFoundException("User not found"));
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel updateUser(Long id, UserModel model) {

        UserModel user = userRepository.findById(id).orElseThrow (()->new UserNotFoundException("User not found"));
        user.setName(model.getName());
        user.setEmail(model.getEmail());
        user.setPassword(model.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        UserModel user = userRepository.findById(id).orElseThrow (()->new UserNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
