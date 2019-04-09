package com.marshmallow.cleaningrobot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marshmallow.cleaningrobot.model.CleaningInstruction;
import com.marshmallow.cleaningrobot.model.CleaningOutcome;
import com.marshmallow.cleaningrobot.service.SeaCleaningRobotService;

import io.swagger.annotations.ApiOperation;


@RestController
public class SeaCleaningController {

	private SeaCleaningRobotService SeaCleaningRobotService;
	
	@Autowired
	public SeaCleaningController(SeaCleaningRobotService SeaCleaningRobotService) {
		this.SeaCleaningRobotService = SeaCleaningRobotService;
	}
	@PostMapping("/clean")
	@ApiOperation("Post the cleaning instructions and perform cleaning operation")
	public ResponseEntity<CleaningOutcome> cleanTheSea(@RequestBody CleaningInstruction instructions){
		
		return ResponseEntity.ok(SeaCleaningRobotService.cleanTheSea(instructions));
	}
}
