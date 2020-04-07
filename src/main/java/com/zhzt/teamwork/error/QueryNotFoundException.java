package com.zhzt.teamwork.error;

import java.util.Set;

public class QueryNotFoundException extends RuntimeException {
    public QueryNotFoundException(Long id){
        super("Object id not found : " + id);
    }
}
