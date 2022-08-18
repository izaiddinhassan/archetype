package com.example.demo.controller;

import com.example.demo.model.base.EmptyRequest;
import com.example.demo.model.base.EmptyResponse;
import com.example.demo.model.request.*;
import com.example.demo.model.response.*;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    private final CreateUserService createUserService;
    private final DeleteUserService deleteUserService;
    private final GetUserService getUserService;
    private final GetUsersService getUsersService;
    private final UpdateUserService updateUserService;

    public UserController(CreateUserService createUserService, DeleteUserService deleteUserService, GetUserService getUserService, GetUsersService getUsersService, UpdateUserService updateUserService) {
        this.createUserService = createUserService;
        this.deleteUserService = deleteUserService;
        this.getUserService = getUserService;
        this.getUsersService = getUsersService;
        this.updateUserService = updateUserService;
    }

    @PostMapping(value = "/user", produces = "application/json")
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest request) {
        return createUserService.execute(request);
    }

    @DeleteMapping("/user/{userId}")
    public EmptyResponse deleteUser(DeleteUserRequest request) {
        return deleteUserService.execute(request);
    }

    @GetMapping("/user/{userId}")
    public GetUserResponse getUser(GetUserRequest request) {
        return getUserService.execute(request);
    }

    @GetMapping("/users")
    public GetUsersResponse getAllUsers(GetUsersRequest request) {
        return getUsersService.execute(request);
    }

    @PutMapping("/user")
    public UpdateUserResponse updateUser(@RequestBody UpdateUserRequest request) {
        return updateUserService.execute(request);
    }
}
