package com.hanson.request.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hanson
 * @date 2024/3/27 12:20
 */
@RestController
@Slf4j
public class RequestController {

    @GetMapping("/test")
    public String test(HttpServletRequest request) throws Exception{
        log.info("线程：{}",Thread.currentThread().getName());
        Thread.sleep(2000);
        return  "success";
    }

}
