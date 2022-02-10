package com.rs.api_querydsl.model;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse extends HashMap<String, Object> {

    public static final int CODE_SUCCESS = 200;
    public static final int CODE_INTERNAL_ERROR = 500;

    public ApiResponse(){
        super.put("status", CODE_SUCCESS);
    }

    public ApiResponse(Exception ex){
        super.put("status", CODE_INTERNAL_ERROR);
        super.put("message", ex.getMessage());
    }
    public ApiResponse(int code, String message){
        super.put("status", code);
        super.put("message", message);
    }

    private Map<String, Object> getData(){
        Map<String, Object> data = (Map<String, Object>) super.get("data");
        if(data == null){
            data = new HashMap<String, Object>();
            super.put("data", data);
        }
        return data;
    }

    public void setData(Object obj){
        this.put("data", obj);
    }

    public void setData(String key, Object value){
        getData().put(key, value);
    }
}

