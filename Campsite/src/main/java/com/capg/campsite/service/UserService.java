package com.capg.campsite.service;
 
import java.util.List;
 
import com.capg.campsite.entity.User;
import com.capg.campsite.exception.UserAlreadyExistsException;
//import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.exception.UserNotFoundException;
 
public interface UserService {
    public List<User> getAllUsers() throws UserNotFoundException;
 
    public User addUser(User user) throws UserAlreadyExistsException;
 
   
 
    public User getUserById(long userId) throws  UserNotFoundException;
 
    public void deleteUser(long userId) throws  UserNotFoundException;
    public User updateUserByEmail(String email, User user) throws UserNotFoundException;
 
    
 
}
