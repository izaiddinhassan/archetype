package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.request.GetUserRequest;
import com.example.demo.model.response.GetUserResponse;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserService implements BaseService<GetUserRequest, GetUserResponse> {

    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetUserResponse execute(GetUserRequest request) {

        var user = getUserById(request.getUserId());

        return buildResponse(user);
    }

    private UserEntity getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow();
    }
    private GetUserResponse buildResponse(UserEntity user) {
        return GetUserResponse.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .mobileNo(user.getMobileNo())
                .identificationNo(user.getIdentificationNo())
                .build();
    }
}
