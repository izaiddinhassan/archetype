package com.example.demo.model.request;

import com.example.demo.model.base.BaseRequest;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateUserRequest extends BaseRequest implements Serializable {

    private String userId;
    private String firstName;
    private String lastName;
}