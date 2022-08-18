package com.example.demo.webservice.model;

import com.example.demo.model.base.BaseResponse;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MockApiResponse extends BaseResponse {

    private String userId;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String identificationNo;
}
