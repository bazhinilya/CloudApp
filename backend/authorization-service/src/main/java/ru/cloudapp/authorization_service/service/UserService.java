package ru.cloudapp.authorization_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Service;

import ru.cloudapp.authorization_service.model.User;
import ru.cloudapp.authorization_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void authenticate(String username) throws Exception {
        try {
            User user = getUserByUsername(username);
            //TODO: Запрос на бота
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    private User getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username)).orElseThrow();
    }
}