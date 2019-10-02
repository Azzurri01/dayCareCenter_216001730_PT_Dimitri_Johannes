package com.djohannes.ac.za.factory.user;

import com.djohannes.ac.za.domain.user.ResponseObj;

public class ResponseObjFactory {

    public static ResponseObj buildGenericResponseObj(String responseCode, String responseDescription) {
        return new ResponseObj(responseCode, responseDescription);
    }
}
