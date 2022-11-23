package com.project.api.domain;

public class Room {
	private String label;
	private Grid grid;
	
	public Room(String label, int[] dimensions) {
		this.label = label;
		this.grid = new Grid(dimensions);
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public Grid getGrid() {
		return grid;
	}
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	
	protected class Grid {
		private int[] dimensions;
		private boolean[][] cells;
		
		public Grid(int[] dimensions) {
			this.dimensions = dimensions;
			this.cells = new boolean[dimensions[0]][dimensions[1]];
			
		}
		
		public int[] getDimensions() {
			return dimensions;
		}
		public void setDimensions(int[] dimensions) {
			this.dimensions = dimensions;
		}
		
		public boolean[][] getCells() {
			return cells;
		}
		public void setCells(boolean[][] cells) {
			this.cells = cells;
		}
	}

	@Override
	public String toString() {
		return "Room [label=" + label + ", grid=" + grid + "]";
	}
}
