package com.capg.campsite.service;
 
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.capg.campsite.entity.User;
import com.capg.campsite.exception.UserAlreadyExistsException;
//import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.exception.UserNotFoundException;
import com.capg.campsite.repository.UserRepository;
 
@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserRepository userRepository;
    private static final Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);
 
    @Override
    public List<User> getAllUsers() throws UserNotFoundException {
        if (userRepository.findAll().isEmpty()) {

        }
        logger.info("get all users");
        return userRepository.findAll();
    }
 
    @Override
    public User addUser(User user) throws UserAlreadyExistsException {
        if (!userRepository.findById(user.getUserId()).isEmpty()) {
            throw new UserAlreadyExistsException("User already exists with id : " + user.getUserId());
        }
        logger.info("add user");
        return userRepository.save(user);
    }


@Override
    public User updateUserByEmail(String email, User user) throws UserNotFoundException {
        User existingUser = userRepository.findByEmail(email);
        if (existingUser == null) {
        throw new UserNotFoundException("User with email " + email + " not found");
        }
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setAddress(user.getAddress());
        existingUser.setPassword(user.getPassword());
        // update other fields as necessary
        return userRepository.save(existingUser);
        }

 
    @Override
    public User getUserById(long userId) throws UserNotFoundException {
        logger.info("get user by Id");
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not exists with id : " + userId));
    }
 
    @Override
    public void deleteUser(long userId) throws UserNotFoundException {
        logger.info("delete user");
        User u = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id : " + userId));
        userRepository.delete(u);
 
    }
}
