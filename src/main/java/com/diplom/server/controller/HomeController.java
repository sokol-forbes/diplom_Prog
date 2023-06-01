package com.diplom.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(produces = PageAttributes.MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
    private AccountService accountService;
    @GetMapping
    public Page<VacancyDto> getAllVacancy(@RequestParam(defaultValue = "0", required = false) Integer page,
                                          @RequestParam(defaultValue = "20", required = false) Integer size){
        return vacancyService.getAllVacancy(page,size);
    }
}
