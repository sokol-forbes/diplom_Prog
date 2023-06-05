package com.diplom.server.controller;

import com.diplom.server.dto.DepartureDto;
import com.diplom.server.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(produces = PageAttributes.MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {
    private DepartmentService accountService;
    @GetMapping
    public Page<DepartureDto> getAllVacancy(@RequestParam(defaultValue = "0", required = false) Integer page,
                                            @RequestParam(defaultValue = "20", required = false) Integer size){
        return accountService.getAllVacancy(page,size);
    }
}
