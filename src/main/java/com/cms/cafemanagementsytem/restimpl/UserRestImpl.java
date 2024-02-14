package com.cms.cafemanagementsytem.restimpl;

import com.cms.cafemanagementsytem.constents.CafeConstants;
import com.cms.cafemanagementsytem.rest.UserRest;
import com.cms.cafemanagementsytem.service.UserService;
import com.cms.cafemanagementsytem.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {
    @Autowired
     UserService userService;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestmap) {
        try {
           return userService.signUp(requestmap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_RONG ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
