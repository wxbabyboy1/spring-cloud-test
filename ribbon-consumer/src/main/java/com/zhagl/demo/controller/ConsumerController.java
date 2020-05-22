package com.zhagl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        //访问服务
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping(value = "/ribbon-user", method = RequestMethod.GET)
    public String helloUser(){
        //访问服务，有占位符。参数有url，返回数据类型，参数的值可多个
        return restTemplate.getForEntity("http://HELLO-SERVICE/user?name={1}&age={2}", String.class, "didi", 18).getBody();
    }

    /*@RequestMapping(value = "/ribbon-user-obj", method = RequestMethod.GET)
    public String helloUserObj(){
        //访问服务
        ResponseEntity<User> responseEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user-obj?name={1}", User.class, "didi");
        User body = responseEntity.getBody();
        return body.name;
    }*/

    @RequestMapping(value = "/ribbon-map", method = RequestMethod.GET)
    public String helloMap(){
        Map<String, String> params = new HashMap<>();
        params.put("name", "data");
        params.put("time", LocalDateTime.now().toString());
        //访问服务，有占位符。参数是map
        return restTemplate.getForEntity("http://HELLO-SERVICE/papa?name={name}&time={time}", String.class, params).getBody();
    }

    /*@RequestMapping(value = "/ribbon-post-user", method = RequestMethod.POST)
    public String helloPostUser(){
        User user = new User("didi", 30);
        //访问服务，传参user，返回string。post的还有类似ribbon-user传多参数，类似ribbon-map传map
        return restTemplate.postForEntity("http://HELLO-SERVICE/postUser", user, String.class).getBody();
    }*/
}
