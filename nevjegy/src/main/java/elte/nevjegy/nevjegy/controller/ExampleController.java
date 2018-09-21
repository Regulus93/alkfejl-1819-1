package elte.nevjegy.nevjegy.controller;

import elte.nevjegy.nevjegy.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    @GetMapping("/hello")
    public String hello(
            @RequestParam(value = "lang", defaultValue = "hu") String language
    ){
        if(StringUtils.isEmpty(language)) language = "hu";
        return exampleService.getHello(language);
    }
}
