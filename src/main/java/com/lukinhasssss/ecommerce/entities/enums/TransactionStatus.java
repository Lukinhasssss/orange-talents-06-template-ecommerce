package com.lukinhasssss.ecommerce.entities.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionStatus {

    SUCCESS, ERROR;

    public static TransactionStatus convert(String status){
        Map<String, TransactionStatus> mapper = new HashMap<String, TransactionStatus>();
        mapper.put("1", TransactionStatus.SUCCESS);
        mapper.put("0", TransactionStatus.ERROR);

        return mapper.get(status);
    }

}
