package com.technoglitz.service.currentuser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.technoglitz.domain.CurrentUser;
import com.technoglitz.domain.Role;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == Role.MANAGER || currentUser.getRole() == Role.FINANCE || currentUser.getId().equals(userId));
    }

}
