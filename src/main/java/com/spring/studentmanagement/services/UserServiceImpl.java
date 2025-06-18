package com.spring.studentmanagement.services;

import com.spring.studentmanagement.exceptions.UserNotFoundException;
import com.spring.studentmanagement.models.AppUser;
import com.spring.studentmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public AppUser getUserById(Long userId) throws UserNotFoundException {
        log.info("Trying to getUserById with param: userId = {}", userId);

        return this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public AppUser saveUser(AppUser user) {
        user.setDateAdded(LocalDateTime.now());
        return userRepository.save(user);
    }


}


