package com.uap.proiv.jobs.service.impl;

import com.uap.proiv.jobs.client.UserApiRepository;
import com.uap.proiv.jobs.dto.User;
import com.uap.proiv.jobs.dto.UserApiResponse;
import com.uap.proiv.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uap.proiv.jobs.dto.UserRequest;

@Service
public class UserServiceImpl implements UserService {
    private final UserApiRepository userApiRepository;

    @Autowired
    public UserServiceImpl(UserApiRepository userApiRepository) {
        this.userApiRepository = userApiRepository;
    }


    @Override
    public UserApiResponse search(int page) {
        UserApiResponse userApiResponse = userApiRepository.getUsers(page);
        int id = 1;
       for (User user:userApiResponse.getData()){
            user.setJobId(id);
            id++;
        };
        return userApiResponse;
    }

    @Override
    public User searchById(int id) {
        User user =  userApiRepository.getUserById(id);
        user.setJobId(1);
        return user;
    }

    @Override
    public void update(User user) {
        try {
            userApiRepository.updateUser( user);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar el usuario: " + e.getMessage(), e);
        }
    }

    @Override
    public User create(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAvatar(request.getAvatar());
        if (request.getJobId() != null) {
            user.setJobId(request.getJobId());
        }
        return userApiRepository.createUser(user);
    }
}
