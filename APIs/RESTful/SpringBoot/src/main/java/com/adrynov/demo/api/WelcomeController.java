package com.adrynov.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController()
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public final String sayHello() throws UnknownHostException {
        return "Hello World from " + InetAddress.getLocalHost().getHostAddress();
    }

}
