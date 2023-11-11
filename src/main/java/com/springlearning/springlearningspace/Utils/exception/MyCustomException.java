package com.springlearning.springlearningspace.Utils.exception;

public class MyCustomException extends RuntimeException{

    private final int INTERNAL_STATUS_CODE = 5000;

    public MyCustomException(String message){
        super(message);

    }

    public int getINTERNAL_STATUS_CODE(){
        return INTERNAL_STATUS_CODE;
    }


}
