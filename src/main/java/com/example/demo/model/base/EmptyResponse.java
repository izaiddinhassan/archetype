package com.example.demo.model.base;

import com.example.demo.model.base.BaseResponse;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonSerialize
@EqualsAndHashCode(callSuper = true)
public class EmptyResponse extends BaseResponse {
}
