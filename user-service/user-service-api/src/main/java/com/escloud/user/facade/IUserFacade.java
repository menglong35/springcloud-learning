package com.escloud.user.facade;

import com.escloud.user.domain.user;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2018-7-24.
 */

@RequestMapping("/user")
public interface IUserFacade {

    @RequestMapping(value="list",method= RequestMethod.GET)
    public List<user> listuser();

    @RequestMapping(value="findAllUser",method=RequestMethod.GET)
    public List<user> findAlluser();


    @RequestMapping(value="get",method=RequestMethod.GET)
    public user getuser(@RequestParam("id") Integer id);


}
