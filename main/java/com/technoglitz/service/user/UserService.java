package com.technoglitz.service.user;

import java.util.Collection;
import java.util.Optional;

import com.technoglitz.domain.User;
import com.technoglitz.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);
    
    Collection<User> getAllManagers();

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
