package com.escloud.user.consumer.Controller;

import com.escloud.user.consumer.Service.UserService;
import com.escloud.user.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2018-7-24.
 */
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<user> listProduct() {
        List<user> list = this.userService.listProduct();
        return list;
    }
}
