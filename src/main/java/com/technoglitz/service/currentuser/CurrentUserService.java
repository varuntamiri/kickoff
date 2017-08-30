package com.technoglitz.service.currentuser;

import com.technoglitz.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
