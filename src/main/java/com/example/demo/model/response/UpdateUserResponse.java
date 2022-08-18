package com.example.demo.model.response;

import com.example.demo.model.base.BaseResponse;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateUserResponse extends BaseResponse implements Serializable {

    private String userId;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String identificationNo;
}
