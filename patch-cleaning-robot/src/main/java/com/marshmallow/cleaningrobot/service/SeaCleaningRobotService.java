package com.marshmallow.cleaningrobot.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.marshmallow.cleaningrobot.exception.NavigationOutOfBoundException;
import com.marshmallow.cleaningrobot.model.CleaningInstruction;
import com.marshmallow.cleaningrobot.model.CleaningOutcome;

@Service
public class SeaCleaningRobotService {
	
	private int[][] seaMatrix;
	public CleaningOutcome cleanTheSea(CleaningInstruction cleaningInstruction) {
		
		
		Integer sizeX = cleaningInstruction.getAreaSize().get(0);
		Integer sizeY = cleaningInstruction.getAreaSize().get(1);
		seaMatrix = new int[sizeX][sizeY];
		
		for (List<Integer> oilPatch : cleaningInstruction.getOilPatches()) {
			seaMatrix[oilPatch.get(0)][oilPatch.get(1)] = 1;
		}
		
		char[] navigationArray = cleaningInstruction.getNavigationInstructions().toCharArray();
		
		int currentX = cleaningInstruction.getStartingPosition().get(0);
		int currentY = cleaningInstruction.getStartingPosition().get(1);
		int cleanedPatchCounter = 0;
		for (char direction : navigationArray) {
			
			if(checkBoundries(sizeX, sizeY, currentX, currentY, direction)) {
				// y+1 to go to North
				if(direction == 'N') {
					if(seaMatrix[currentX][currentY+1] == 1) {
						cleanedPatchCounter++;
					}
					currentY++;
				}
				//y-1 to go to South
				if(direction == 'S') {
					if(seaMatrix[currentX][currentY-1] == 1) {
						cleanedPatchCounter++;
					}
					currentY--;
				}
				//x+1 to go to East
				if(direction == 'E') {
					if(seaMatrix[currentX + 1][currentY] == 1) {
						cleanedPatchCounter++;
					}
					currentX++;
				}
				//x-1 to go to West
				if(direction == 'W') {
					if(seaMatrix[currentX - 1][currentY] == 1) {
						cleanedPatchCounter++;
					}
					currentX--;
				}
				seaMatrix[currentX][currentY] = 0;
			} else {
				throw new NavigationOutOfBoundException("Going to " + direction + " from [" + currentX + " , " + currentY + "] is not possible");
			}
			
		}
		Integer[] finalPosition = {currentX, currentY};
		return new CleaningOutcome(Arrays.asList(finalPosition), cleanedPatchCounter);
	}
	private boolean checkBoundries(Integer sizeX, Integer sizeY, int currentX, int currentY, char direction) {
		switch(direction) {
		case 'N' : return sizeY > currentY + 1;
		case 'S' : return (currentY - 1 > 0 || currentY - 1 == 0);
		case 'E' : return sizeX > currentX + 1;
		case 'W' : return (currentX - 1 > 0 || currentX - 1 == 0);
		default : return false;
		}
	}
}
