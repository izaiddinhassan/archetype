package com.example.demo.model.request;

import com.example.demo.model.base.BaseRequest;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUserRequest extends BaseRequest {

    private String userId;
}
