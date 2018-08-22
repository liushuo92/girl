package com.lawrence.controller;

import com.lawrence.propertites.GirlPropertites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liush
 * 2018/8/20   14:17
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Value("${girl.cupSize}")
    private String cupSize;

    @Value("${girl.age}")
    private Integer age;

    @Value("${content}")
    private String content;


    @Autowired
    private GirlPropertites girlPropertites;

    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer tid){
        return "id:" + tid;
//        return girlPropertites.getCupsize() + content;
    }

//    @RequestMapping(value = "/say",method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String talk(@RequestParam(value = "id",required = false,defaultValue = "0") Integer tid){
//        return "id:" + tid;
        return girlPropertites.getCupsize() + content;
    }

    @RequestMapping(value = "demo",method = RequestMethod.GET)
    public String demo(){
        return cupSize;
    }
}
