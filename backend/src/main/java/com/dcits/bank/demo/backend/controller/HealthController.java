package com.dcits.bank.demo.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public Map<String, Object> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/api/protected/test")
    public Map<String, Object> test() {
        return Map.of("result_code", 0, "result_msg", "auth passed");
    }
}
