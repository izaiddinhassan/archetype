package com.example.demo.model.request;

import com.example.demo.model.base.BaseRequest;
import lombok.*;

import javax.validation.constraints.NotBlank;
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
