package com.project.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.domain.Request;
import com.project.api.domain.Robot;
import com.project.api.service.RobotService;
import com.project.api.service.exception.UnsupportedOperationException;

@RestController
@RequestMapping("/robots")
public class RobotController {
	@Autowired
	private RobotService robotService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Robot> getRobot(@RequestBody Request request) throws UnsupportedOperationException {
		Robot robot = robotService.createRobot(request);
		robotService.move(robot, request.instructions);

		return new ResponseEntity<Robot>(robot, HttpStatus.OK);
	}
}
