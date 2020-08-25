package com.teste2boot.demospring2.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long seriaVersion = 1L;

    private String fielName;
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fielName, String message) {
        this.fielName = fielName;
        this.message = message;
    }

    public String getFielName() {
        return fielName;
    }

    public void setFielName(String fielName) {
        this.fielName = fielName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
