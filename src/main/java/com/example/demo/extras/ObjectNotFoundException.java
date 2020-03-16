package com.example.demo.extras;

public class ObjectNotFoundException extends RuntimeException{
    private String typeOfObject;

    public ObjectNotFoundException(String message){
        super(message);
    }

    public ObjectNotFoundException(String message, String typeOfObject){
        super(message);
        this.typeOfObject = typeOfObject;
    }

    public ObjectNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public String getTypeOfObject() {
        return typeOfObject;
    }

    public void setTypeOfObject(String typeOfObject) {
        this.typeOfObject = typeOfObject;
    }
}
