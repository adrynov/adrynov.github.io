package com.adrynov.benchmarking.api;

import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/actors")
public class ActorController {

    @ResponseBody
    @GetMapping()
    public String hello() {
        return "Hello World";
    }

}
