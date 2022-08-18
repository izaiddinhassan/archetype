package com.example.demo.model.response;

import com.example.demo.model.base.BaseResponse;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUserResponse extends BaseResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String identificationNo;
}
