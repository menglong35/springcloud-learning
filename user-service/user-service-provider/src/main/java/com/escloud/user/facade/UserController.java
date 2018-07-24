package com.escloud.user.facade;

import com.escloud.user.domain.user;
import com.escloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018-7-24.
 */
@RestController()
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value="list",method= RequestMethod.GET)
    public List<user> listuser(){
        return userService.listuser();
    }

    @RequestMapping(value="findAllUser",method=RequestMethod.GET)
    public List<user> findAlluser(){
        return userService.findAlluser();
    }


    @RequestMapping(value="get",method=RequestMethod.GET)
    public user getuser(@RequestParam("id") Integer id){
        return userService.getuser(id);
    }
}
