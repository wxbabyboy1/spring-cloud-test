package com.zhagl.demo.service;

import com.zhagl.demo.dto.User;
import org.springframework.web.bind.annotation.*;

//@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello6", method = RequestMethod.POST)
    String hello(@RequestBody User user);

    @RequestMapping(value = "/hello7", method = RequestMethod.GET)
    String hello();
}
