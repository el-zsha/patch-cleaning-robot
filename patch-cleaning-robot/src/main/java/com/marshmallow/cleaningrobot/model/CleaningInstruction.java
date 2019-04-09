package com.marshmallow.cleaningrobot.model;


import java.util.List;

public class CleaningInstruction {
	private List<Integer> areaSize;
	private List<Integer> startingPosition;
	private List<List<Integer>> oilPatches;
	private String navigationInstructions;
	
	public List<Integer> getAreaSize() {
		return areaSize;
	}
	public void setAreaSize(List<Integer> areaSize) {
		this.areaSize = areaSize;
	}
	public List<Integer> getStartingPosition() {
		return startingPosition;
	}
	public void setStartingPosition(List<Integer> startingPosition) {
		this.startingPosition = startingPosition;
	}
	public List<List<Integer>> getOilPatches() {
		return oilPatches;
	}
	public void setOilPatches(List<List<Integer>> oilPatches) {
		this.oilPatches = oilPatches;
	}
	public String getNavigationInstructions() {
		return navigationInstructions;
	}
	public void setNavigationInstructions(String navigationInstructions) {
		this.navigationInstructions = navigationInstructions;
	}
	
}
