package com.homework.controller;

import com.homework.dto.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataController {

    @PostMapping
    DataDto create (@RequestBody DataDto dataDto) {
        log.info("Received create data request: {}", dataDto);
        return new DataDto();
    }
}
