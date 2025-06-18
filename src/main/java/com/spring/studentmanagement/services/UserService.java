package com.spring.studentmanagement.services;

import com.spring.studentmanagement.exceptions.UserNotFoundException;
import com.spring.studentmanagement.models.AppUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    List<AppUser> findAllUsers();

    void deleteUserById(Long userId);

    AppUser getUserById(Long userId) throws UserNotFoundException;

    AppUser saveUser(AppUser user);

}
