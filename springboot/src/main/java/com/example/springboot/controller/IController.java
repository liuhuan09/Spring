package com.example.springboot.controller;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 2020年8月6日17:44:10
 * 刘欢
 */
@RestController
public class IController {

    @RequestMapping("/")
    @ResponseBody
    public Map<String,String> index(String name ){
        Map<String,String> map =null;
        map.put("Msg","I'm 学习");
        return map;
    }
}
