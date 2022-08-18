package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.request.UpdateUserRequest;
import com.example.demo.model.response.UpdateUserResponse;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UpdateUserService implements BaseService<UpdateUserRequest, UpdateUserResponse> {

    private final UserRepository userRepository;

    public UpdateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UpdateUserResponse execute(UpdateUserRequest request) {

        var updatedUser = updateUser(request);

        return buildResponse(updatedUser);
    }

    private UserEntity updateUser(UpdateUserRequest request) {
        var user = userRepository.findById(request.getUserId())
                .orElseThrow();

        log.info("User: {}", user);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        return userRepository.save(user);
    }

    private UpdateUserResponse buildResponse(UserEntity updatedUser) {
        return UpdateUserResponse.builder()
                .userId(updatedUser.getUserId())
                .firstName(updatedUser.getFirstName())
                .lastName(updatedUser.getLastName())
                .mobileNo(updatedUser.getMobileNo())
                .identificationNo(updatedUser.getIdentificationNo())
                .build();
    }
}
