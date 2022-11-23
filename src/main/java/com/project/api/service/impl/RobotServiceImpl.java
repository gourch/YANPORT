package com.project.api.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.api.domain.DIRECTION;
import com.project.api.domain.Request;
import com.project.api.domain.Robot;
import com.project.api.domain.Room;
import com.project.api.service.RobotService;
import com.project.api.service.exception.UnsupportedOperationException;

@Service
public class RobotServiceImpl implements RobotService {

	@Override
	public Robot createRobot(Request request) throws UnsupportedOperationException {
		int[] dimensions = request.room.dimensions;
		int[] coordinates = request.robot.coordinates;
		DIRECTION direction = DIRECTION.valueOf(request.robot.direction);
		
		if ((coordinates[0] > dimensions[0]) || (coordinates[0] > dimensions[0])) {
			throw new UnsupportedOperationException("room.out");
		}
		
		Optional<Room> room = Optional.of(new Room(request.room.label, dimensions));
		Optional<Robot> robot = Optional.of(new Robot(request.robot.label, room.get(), coordinates, direction));

		return robot.get();
	}

	@Override
	public void turnRight(Robot robot) {
		switch (robot.getDirection()) {
		case N:
			robot.setDirection(DIRECTION.E);
			break;
		case E:
			robot.setDirection(DIRECTION.S);
			break;
		case W:
			robot.setDirection(DIRECTION.N);
			break;
		case S:
			robot.setDirection(DIRECTION.W);
			break;
		default:
			break;
		}

	}

	@Override
	public void turnLeft(Robot robot) {
		switch (robot.getDirection()) {
		case N:
			robot.setDirection(DIRECTION.W);
			break;
		case E:
			robot.setDirection(DIRECTION.N);
			break;
		case W:
			robot.setDirection(DIRECTION.S);
			break;
		case S:
			robot.setDirection(DIRECTION.E);
			break;
		default:
			break;
		}

	}

	@Override
	public void forward(Robot robot) {
		switch (robot.getDirection()) {
		case N:
			robot.setCoordinates(new int[] { robot.getCoordinates()[0], robot.getCoordinates()[1] + 1 });
			break;
		case E:
			robot.setCoordinates(new int[] { robot.getCoordinates()[0] + 1, robot.getCoordinates()[1] });
			break;
		case W:
			robot.setCoordinates(new int[] { robot.getCoordinates()[0] - 1, robot.getCoordinates()[1] });
			break;
		case S:
			robot.setCoordinates(new int[] { robot.getCoordinates()[0], robot.getCoordinates()[1] - 1 });
			break;
		default:
			break;
		}

	}

	@Override
	public void move(Robot robot, String str) {
		char[] ch = str.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			switch (ch[i]) {
			case 'D':
				turnRight(robot);
				break;
			case 'G':
				turnLeft(robot);
				break;
			case 'A':
				forward(robot);
				break;
			default:
				break;
			}
		}

	}

}
