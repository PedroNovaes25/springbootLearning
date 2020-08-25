package com.teste2boot.demospring2.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private static final long seriaVersion = 1L;

    List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> geterrors() {
        return errors;
    }

    public void addError(String fielName, String message){
        errors.add(new FieldMessage(fielName, message));
    }
}
