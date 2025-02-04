package edu.neu.csye7374;

public class BearMarketStrategy implements CostStrategy{
	
    @Override
    public double calculateNewCost(double currentCost) {
    	// TODO Auto-generated method stub
        return currentCost * 0.80; 	//cost reduced
    }
}