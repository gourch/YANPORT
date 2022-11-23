package com.project.api.domain;

import java.util.Arrays;

public class Robot {
	private String label;
	private Room room;
	private int[] coordinates;
	private DIRECTION direction;
	
	public Robot(String label, Room room, int[] coordinates, DIRECTION direction) {
		this.label = label;
		this.room = room;
		this.coordinates = coordinates;
		this.direction = direction;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	public int[] getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}

	public DIRECTION getDirection() {
		return direction;
	}
	public void setDirection(DIRECTION direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Robot [label=" + label + ", room=" + room + ", coordinates=" + Arrays.toString(coordinates)
				+ ", direction=" + direction + "]";
	}
}
