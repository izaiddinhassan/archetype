package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.request.CreateUserRequest;
import com.example.demo.model.response.CreateUserResponse;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreateUserService implements BaseService<CreateUserRequest, CreateUserResponse>{

    private final UserRepository userRepository;

    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse execute(CreateUserRequest request) {

        var createdUser = createNewUser(request);

        return buildResponse(createdUser);
    }

    private UserEntity createNewUser(CreateUserRequest request) {
        var userEntity = buildUserFromRequest(request);

        return userRepository.save(userEntity);
    }

    private UserEntity buildUserFromRequest(CreateUserRequest request) {
        return UserEntity.builder()
                .userId(UUID.randomUUID().toString())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .mobileNo(request.getMobileNo())
                .identificationNo(request.getIdentificationNo())
                .build();
    }

    private CreateUserResponse buildResponse(UserEntity createdUser){
        return CreateUserResponse.builder()
                .userId(createdUser.getUserId())
                .firstName(createdUser.getFirstName())
                .lastName(createdUser.getLastName())
                .mobileNo(createdUser.getMobileNo())
                .identificationNo(createdUser.getIdentificationNo())
                .build();
    }
}
