package com.escloud.user.service;

import com.escloud.user.domain.user;
import com.escloud.user.facade.IUserFacade;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-7-24.
 */
@Service
public class UserService  {

    public List<user> listuser() {
        List<user> userList =new ArrayList<user>();
        user u =  new user();
        u.setId(11);
        u.setUserName("陈省");
        u.setEmail("chenxinga@digiwin.com");
        userList.add(u);

        user u2 =  new user();
        u2.setId(22);
        u2.setUserName("abc");
        u2.setEmail("abc@digiwin.com");
        userList.add(u);

        return userList;
    }


    public List<user> findAlluser() {
        return null;
    }


    public user getuser(@RequestParam("id") Integer id) {
        user u =  new user();
        u.setId(11);
        u.setUserName("陈省");
        u.setEmail("chenxinga@digiwin.com");
        return u;
    }
}
