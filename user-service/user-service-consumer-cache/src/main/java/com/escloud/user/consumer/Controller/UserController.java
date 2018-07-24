package com.escloud.user.consumer.Controller;

import com.escloud.user.consumer.Service.UserService;
import com.escloud.user.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018-7-24.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public user get(Integer id){
        return this.userService.get(id);
    }

    @RequestMapping(value = "del", method = RequestMethod.GET)
    public void del(Integer id){
        this.userService.del(id);
    }
}
