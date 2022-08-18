package com.example.demo.service;

import com.example.demo.model.request.DeleteUserRequest;
import com.example.demo.model.base.EmptyResponse;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class DeleteUserService implements BaseService<DeleteUserRequest, EmptyResponse> {

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public EmptyResponse execute(DeleteUserRequest request) {

        deleteUserById(request.getUserId());

        return new EmptyResponse();
    }

    private void deleteUserById(String userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(
                        userRepository::delete,
                        () -> log.warn("Requested User Id not exist in database")

                );
    }
}
