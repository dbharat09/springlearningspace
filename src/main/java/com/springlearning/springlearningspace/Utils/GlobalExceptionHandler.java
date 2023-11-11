package com.springlearning.springlearningspace.Utils;

import com.springlearning.springlearningspace.Utils.exception.MyCustomException;
import com.springlearning.springlearningspace.data.ExceptionData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (MyCustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionData> handleBadRequest(MyCustomException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ExceptionData.builder()
                        .statusCode(e.getINTERNAL_STATUS_CODE())
                        .payLoad(e.getMessage())
                        .build());
    }

}
