package com.example.demo.service;

import com.example.demo.model.base.BaseRequest;
import com.example.demo.model.base.BaseResponse;

public interface BaseService<T extends BaseRequest,V extends BaseResponse> {

    V execute(T request);
}
