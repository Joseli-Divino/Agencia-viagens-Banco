package com.api.travelagency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping("/")
    public String home() {
        return "Seja bem-vindo(a) ao Travel Agency API! Acesse /api/destinations para ver os destinos disponíveis.";
    }
}
