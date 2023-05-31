package by.asb.mti.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/only-admin")
    public String hello(Authentication authentication) {
        return "Hello, " + authentication.getName() + "!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/only-user")
    public String hello1(Authentication authentication) {
        return "Hello, " + authentication.getName() + "!";
    }

}
