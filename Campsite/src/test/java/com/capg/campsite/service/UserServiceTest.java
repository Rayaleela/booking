package com.capg.campsite.service;
 
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.campsite.entity.User;
//import com.capg.campsite.exception.ResourceNotFoundException;
import com.capg.campsite.exception.UserNotFoundException;
import com.capg.campsite.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetAllUsers() throws UserNotFoundException {
        
        User user1 = new User();
        user1.setUserId(1L);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("johndoe@example.com");
        user1.setPhoneNumber(1234567890L);
        user1.setAddress("123 Main St, Anytown USA");
        user1.setPassword("password1");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
         when(userRepository.findAll()).thenReturn(userList);

        
        List<User> result = userService.getAllUsers();

        
        assertEquals(userList.size(), result.size());
        assertEquals(userList.get(0).getFirstName(), result.get(0).getFirstName());
        assertEquals(userList.get(0).getLastName(), result.get(0).getLastName());
        assertEquals(userList.get(0).getEmail(), result.get(0).getEmail());
        assertEquals(userList.get(0).getPhoneNumber(), result.get(0).getPhoneNumber());
        assertEquals(userList.get(0).getAddress(), result.get(0).getAddress());
        assertEquals(userList.get(0).getPassword(), result.get(0).getPassword());

    }
    @Test
    public void testGetUserById() throws UserNotFoundException {
        User user = new User();
        user.setUserId(1L);
        user.setEmail("john.doe@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPhoneNumber(1234567890L);
        user.setAddress("123 Main St, Anytown USA");
        user.setPassword("password");
 
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
 
        User response = userService.getUserById(1L);
 
    }
    @Test
    public void testUpdateUser() throws UserNotFoundException {
        User user = new User();
        user.setUserId(1L);
        user.setEmail("john.doe@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPhoneNumber(1234567890L);
        user.setAddress("123 Main St, Anytown USA");
        user.setPassword("password");
 
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
 
        User updatedUser = new User();
        updatedUser.setUserId(1L);
        updatedUser.setEmail("jane.doe@example.com");
        updatedUser.setFirstName("Jane");
        updatedUser.setLastName("Doe");
        updatedUser.setPhoneNumber(9876543210L);
        updatedUser.setAddress("456 High St, Anytown USA");
        updatedUser.setPassword("newPassword");
 
        when(userRepository.save(updatedUser)).thenReturn(updatedUser);
 
 
      verify(userRepository).save(updatedUser);
    }
    @Test
    public void testDeleteUser() throws UserNotFoundException {
        User user = new User();
        user.setUserId(1L);
        user.setEmail("john.doe@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPhoneNumber(1234567890L);
        user.setAddress("123 Main St, Anytown USA");
        user.setPassword("password");
 
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
 
        userService.deleteUser(1L);
 
        verify(userRepository).delete(user);
    } 
    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setUserId(1L);
        user.setEmail("test@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPhoneNumber(1234567890L);
        user.setAddress("123 Main St");
        user.setPassword("password");

        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.addUser(user);

        assertEquals(user.getUserId(), savedUser.getUserId());
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getFirstName(), savedUser.getFirstName());
        assertEquals(user.getLastName(), savedUser.getLastName());
        assertEquals(user.getPhoneNumber(), savedUser.getPhoneNumber());
        assertEquals(user.getAddress(), savedUser.getAddress());
        assertEquals(user.getPassword(), savedUser.getPassword());

        verify(userRepository).findById(1L);
        verify(userRepository).save(user);
    }
 
 
}




    


