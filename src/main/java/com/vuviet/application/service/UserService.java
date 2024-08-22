package com.vuviet.application.service;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.vuviet.application.entity.User;
import com.vuviet.application.model.dto.UserDTO;
import com.vuviet.application.model.request.ChangePasswordRequest;
import com.vuviet.application.model.request.CreateUserRequest;
import com.vuviet.application.model.request.UpdateProfileRequest;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getListUsers();

    Page<User> adminListUserPages(String fullName, String phone, String email, Integer page);

    User createUser(CreateUserRequest createUserRequest);

    void changePassword(User user, ChangePasswordRequest changePasswordRequest);

    User updateProfile(User user, UpdateProfileRequest updateProfileRequest);
}
