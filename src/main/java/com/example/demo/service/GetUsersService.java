package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.model.request.GetUsersRequest;
import com.example.demo.model.response.GetUsersResponse;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
public class GetUsersService implements BaseService<GetUsersRequest, GetUsersResponse> {

    private final UserRepository userRepository;

    public GetUsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public GetUsersResponse execute(GetUsersRequest request) {

        log.info("PAGING PARAM: {}", request);

        var userEntities = getUsersFromDb(request);

        return buildResponse(userEntities);
    }

    private Page<UserEntity> getUsersFromDb(GetUsersRequest request) {
        var page = PageRequest.of(
                request.getPageNo(),
                request.getPageSize(),
                Sort.Direction.fromOptionalString(request.getSortDirection()).orElse(Sort.Direction.DESC),
                request.getSortBy());
        return userRepository.findAll(page);
    }

    private GetUsersResponse buildResponse(Page<UserEntity> userEntities) {
        var users = userEntities.stream()
                .map(it -> GetUsersResponse.User.builder()
                        .userId(it.getUserId())
                        .firstName(it.getFirstName())
                        .lastName(it.getLastName())
                        .mobileNo(it.getMobileNo())
                        .identificationNo(it.getIdentificationNo())
                        .build())
                .collect(Collectors.toList());

        return GetUsersResponse.builder()
                .user(users)
                .build();
    }
}
