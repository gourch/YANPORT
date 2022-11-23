package com.project.api.domain;

public class Request {
	public Room room;
	public Robot robot;
	public String instructions;
	
	public class Room {
		public String label;
	    public int[] dimensions;
	}
	
	public class Robot {
		public String label;
	    public int[] coordinates;
		public String direction;
	}
}