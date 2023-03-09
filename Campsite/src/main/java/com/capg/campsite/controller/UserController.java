package com.capg.campsite.controller;
 
import java.util.List;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.capg.campsite.entity.User;
import com.capg.campsite.exception.UserAlreadyExistsException;
//import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.exception.UserNotFoundException;
import com.capg.campsite.service.UserService;
 
@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    @GetMapping("/get-all-user")
    public ResponseEntity<List<User>> getAllUsers() throws UserNotFoundException {
        return ResponseEntity.ok(userService.getAllUsers());
    }
 
    @GetMapping("/get-user-by-id/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable long userId) throws UserNotFoundException {
 
        return new ResponseEntity(this.userService.getUserById(userId), HttpStatus.OK);
    }
 
    @PostMapping("/register-user")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
 
    }
   
    @PutMapping("/update-user/{email}")
    public ResponseEntity<User> updateUserByEmail(@PathVariable String email, @Valid @RequestBody User user) throws UserNotFoundException {
        User updatedUser = userService.updateUserByEmail(email, user);
        return ResponseEntity.ok(updatedUser);
    }

 
    @DeleteMapping("/delete-user-by-id/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
 
}

