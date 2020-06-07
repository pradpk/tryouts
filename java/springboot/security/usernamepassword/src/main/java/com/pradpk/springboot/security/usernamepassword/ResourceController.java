package com.pradpk.springboot.security.usernamepassword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/access")
    public String access() {
        return "Successfully logged in";
    }
}
