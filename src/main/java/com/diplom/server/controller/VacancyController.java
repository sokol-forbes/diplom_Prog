package com.diplom.server.controller;

import com.diplom.server.dto.VacancyDto;
import com.diplom.server.service.VacancyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(produces = PageAttributes.MediaType.APPLICATION_JSON_VALUE)
public class VacancyController {
    private VacancyService accountService;
    @GetMapping
    public Page<VacancyDto> getAllVacancy(@RequestParam(defaultValue = "0", required = false) Integer page,
                                          @RequestParam(defaultValue = "20", required = false) Integer size){
        return accountService.getAllVacancy(page,size);
    }
}
