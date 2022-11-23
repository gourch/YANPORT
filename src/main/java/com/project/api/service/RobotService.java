package com.project.api.service;

import com.project.api.domain.Request;
import com.project.api.domain.Robot;
import com.project.api.service.exception.UnsupportedOperationException;

public interface RobotService {
	Robot createRobot(Request request) throws UnsupportedOperationException;
	void turnRight(Robot robot);
	void turnLeft(Robot robot);
	void forward(Robot robot);
	void move(Robot robot, String str);
}
