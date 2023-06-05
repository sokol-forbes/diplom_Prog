package com.diplom.server.controller;

import com.diplom.server.dto.BusinessTripsDto;
import com.diplom.server.service.BussinesTripService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(produces = PageAttributes.MediaType.APPLICATION_JSON_VALUE)
public class BussinesTripsController {
    private BussinesTripService bussinesTripService;
    @GetMapping
    public Page<BusinessTripsDto> getAllVacancy(@RequestParam(defaultValue = "0", required = false) Integer page,
                                                @RequestParam(defaultValue = "20", required = false) Integer size){
        return bussinesTripService.getAll(page,size);
    }
}
