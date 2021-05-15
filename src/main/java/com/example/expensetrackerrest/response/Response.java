package com.example.expensetrackerrest.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response {

    private Object data;

    public static Response makeResponse(String fieldName, Object data) {
        Map<String, Object> m = new HashMap<>();
        m.put(fieldName, data);
        Response response = new Response();
        response.setData(m);
        return response;
    }
}
