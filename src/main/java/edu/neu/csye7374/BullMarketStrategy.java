package edu.neu.csye7374;

public class BullMarketStrategy implements CostStrategy {

	@Override
	public double calculateNewCost(double currentCost) {
		// TODO Auto-generated method stub
		return currentCost*1.30;	// cost increased
	}

}
