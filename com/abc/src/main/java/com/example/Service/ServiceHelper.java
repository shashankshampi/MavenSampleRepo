package com.example.Service;


import java.util.HashMap;
import java.util.logging.Logger;

public class ServiceHelper {
    private static final Logger logger = Logger.getLogger(ServiceHelper.class.getName());

    public HashMap<String, Object> createHeader(String str){
        HashMap<String,Object> header = new HashMap<String, Object>();
        header.put("app-id",str);
        return header;
    }
}
