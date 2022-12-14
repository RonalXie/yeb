package com.ronalxie.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBean {

    public Integer code;
    public String message;
    public Object obj;

    public static ResBean success(String message){
        return new ResBean(200,message,null);
    }

    public static ResBean success(String message,Object obj){
        return new ResBean(200,message,obj);
    }

    public static ResBean error(String message){
        return new ResBean(500,message,null);
    }

    public static ResBean error(String message,Object obj){
        return new ResBean(500,message,obj);
    }

}
