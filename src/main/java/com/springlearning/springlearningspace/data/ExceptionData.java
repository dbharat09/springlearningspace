package com.springlearning.springlearningspace.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionData {

    private int statusCode;
    private String payLoad;

}
