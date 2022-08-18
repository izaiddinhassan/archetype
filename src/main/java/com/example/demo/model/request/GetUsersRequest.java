package com.example.demo.model.request;

import com.example.demo.model.base.BaseRequest;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GetUsersRequest extends BaseRequest {
    private int pageNo = 0;
    private int pageSize = 10;
    private String sortBy = "firstName";
    private String sortDirection = "DESC";
}
