package com.project.spring.Endpoint;

import com.google.gson.Gson;
import com.project.spring.DomainObjects.Employee;
import com.project.spring.Services.UnequalPayLookupService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/PayLookup")
public class UnequalPayEndpoint {

    @Autowired
    private UnequalPayLookupService unequalPayLookupService;

    final static Logger logger = LogManager.getLogger(UnequalPayEndpoint.class);

    @ApiOperation(value = "lists all of the employees that make less than their juniors")
    @GetMapping(value = "/unequalEmployees", produces = "application/json")
    @ResponseBody
    public ArrayList<String> findUnequallyPaidEmployees() {
        logger.info("Handling request for list of employees that make less than their juniors");
        ArrayList<String> unequalEmployees = unequalPayLookupService.findUnequallyPaidEmployees();

        logger.info("Successfully generated a response for unequally paid employees");
        return unequalEmployees;
    }

}
