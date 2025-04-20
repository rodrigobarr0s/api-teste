package com.cloud_api_starter.service;

import com.cloud_api_starter.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
