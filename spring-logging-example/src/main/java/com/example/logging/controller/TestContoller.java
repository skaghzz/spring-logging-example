package com.example.logging.controller;

import com.example.logging.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TestService testService;

    @Autowired
    public TestContoller(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/test")
    public ResponseEntity<Void> test() {
        logger.info("start");
        testService.testLog();
        logger.info("end");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
