package com.UMS.Controller;

import com.UMS.Model.UserModel;
import com.UMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UMS")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserModel>  addUSer(@RequestBody UserModel model){
        return new ResponseEntity<>(userService.addUser(model), HttpStatus.CREATED);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<List<UserModel>> addUSers(@RequestBody List<UserModel> model){
        return new ResponseEntity<>(userService.addUsers(model),HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/updateUser/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel model){
        return userService.updateUser(id,model);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUSer(@PathVariable Long id){
        userService.deleteUser(id);
        return "Deleted Successfully";
    }
}
