package com.example.demo.model.request;

import com.example.demo.model.base.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateUserRequest extends BaseRequest implements Serializable {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String mobileNo;

    @NotBlank
    private String identificationNo;
}
