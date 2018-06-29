package com.qinjun.autotest.tsperfagent.controller;

public class Response {
    Boolean success;
    String msg;

    public Response() {}

    public Response(Boolean success,String msg) {
        this.success = success;
        this.msg=msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
