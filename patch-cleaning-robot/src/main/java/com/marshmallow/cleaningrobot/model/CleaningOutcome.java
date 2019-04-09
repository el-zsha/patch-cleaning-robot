package com.marshmallow.cleaningrobot.model;

import java.util.List;

public class CleaningOutcome {
	private List<Integer> finalPosition;
	private int oilPatchesCleaned;
	
	public CleaningOutcome(List<Integer> finalPosition, int oilPatchesCleaned) {
		this.finalPosition = finalPosition;
		this.oilPatchesCleaned = oilPatchesCleaned;
	}
	public List<Integer> getFinalPosition() {
		return finalPosition;
	}
	
	public int getOilPatchesCleaned() {
		return oilPatchesCleaned;
	}
	
	
	
}
