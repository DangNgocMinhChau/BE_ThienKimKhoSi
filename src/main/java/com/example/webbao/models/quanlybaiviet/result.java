package com.example.webbao.models.quanlybaiviet;

public class result<T> {
    private Boolean status;
    private String msg;
    private T result;

    public result(Boolean status, String msg, T result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public result(Boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
