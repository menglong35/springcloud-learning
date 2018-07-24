package com.escloud.user.consumer.Service;

import com.escloud.user.domain.user;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-7-24.
 */

@Service
public class UserService {



    @Cacheable(key="'user' + #id")
    public user get(Integer id){
        System.out.println("=========get========="+id);
        return new user(id,"陈省","chenxinga@digiwin.com");
    }

    @CacheEvict(key="'user' + #id")
    public void del(Integer id){
        System.out.println("=========del========="+id);
    }





}
