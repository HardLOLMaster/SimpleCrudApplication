package com.github.hlam.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MetaController {
    private final String instance_id;

    public MetaController() {
        String instance_id = System.getenv("INSTANCE_ID");
        this.instance_id = instance_id == null ? "generated:" + UUID.randomUUID() : instance_id;
    }

    @GetMapping("/")
    public String getServiceApplicationId() {
        return instance_id;
    }
}
