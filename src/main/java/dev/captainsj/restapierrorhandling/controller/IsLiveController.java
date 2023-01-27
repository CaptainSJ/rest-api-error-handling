package dev.captainsj.restapierrorhandling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsLiveController {

    @GetMapping("/")
    public String isLive() {
        return "Student API is live :)";
    }
}
