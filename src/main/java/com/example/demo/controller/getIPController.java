package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class getIPController {

    @GetMapping("/meu-ip")
    @ResponseStatus( HttpStatus.OK )
    String meuIp(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if ( xfHeader == null ) {
            return "Seu IP é " + request.getRemoteAddr();
        }
        return "Seu IP é " + xfHeader.split(",")[0];
    }
}
