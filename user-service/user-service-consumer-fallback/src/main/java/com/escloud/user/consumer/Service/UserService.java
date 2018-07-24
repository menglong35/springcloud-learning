package com.escloud.user.consumer.Service;

import com.escloud.user.domain.user;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LoadBalancerClient loadBalancerClient;//ribbon 负载均衡客户端

    @HystrixCommand(fallbackMethod = "fallback",
            commandProperties = {
                    //默认10秒;如果并发数达到该设置值，请求会被拒绝和抛出异常并且fallback不会被调用。
                    @HystrixProperty(name= HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value="15")
            })
    public List<user> listProduct(){
        ServiceInstance si=loadBalancerClient.choose("user");
        StringBuffer sb=new StringBuffer("");
        sb.append("http://");
        sb.append(si.getHost());
        sb.append(":");
        sb.append(si.getPort());
        sb.append("/product/list");
        System.out.println(sb.toString());

        RestTemplate rt=new RestTemplate();
        ParameterizedTypeReference<List<user>> typeRef
                =new ParameterizedTypeReference<List<user>>(){};
        ResponseEntity<List<user>> resp=rt.exchange(sb.toString(), HttpMethod.GET, null, typeRef)	;
        List<user> plist=resp.getBody();
        return plist;
    }

    public List<user> fallback(){
        List<user> list=new ArrayList<user>();
        user u =new user();
        u.setId(-1);
        u.setUserName("valid");
        u.setEmail("");
        list.add(u);
        return list;
    }
}
