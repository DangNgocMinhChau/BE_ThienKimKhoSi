package com.example.webbao.models.payload.response;

public class ObjectRepones {
    private Boolean status;
    private String message;

    public ObjectRepones() {

    }

    public ObjectRepones(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}