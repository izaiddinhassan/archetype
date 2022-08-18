package com.example.demo.model.response;

import com.example.demo.model.base.BaseResponse;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUsersResponse extends BaseResponse {

    private List<User> user;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User {
        private String userId;
        private String firstName;
        private String lastName;
        private String mobileNo;
        private String identificationNo;
    }
}