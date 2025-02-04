package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockAPI implements Tradable{

    private String name;

    private double price;

    private String description;
    
    private CostStrategy costStrategy;

  //  private int metric;

    protected List<Double> prevPrices = new ArrayList<>();

    public StockAPI() {
        super();
    }

    public StockAPI(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    public StockAPI(String name, double price, String description, CostStrategy strategy) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.costStrategy = strategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public CostStrategy getCostStrategy() {
		return costStrategy;
	}

	public void setCostStrategy(CostStrategy costStrategy) {
		this.costStrategy = costStrategy;
	}

	private void init(double price) {
        prevPrices.add(price);
    }
	
	public void applyStrategy() {
        if (costStrategy != null) {
            this.price = costStrategy.calculateNewCost(this.price);
        }
    }

    @Override
    public void setBid(double bid) {
        prevPrices.add(bid);
        double newPrice = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum())/prevPrices.size();
        StockMarket.getInstance().updatePrice(this, newPrice);
    }
    
    @Override
    public int getMetric() {
        return price > 50 ? 1 : 0;
    }

/*    @Override
    public int getMetric() {
        if (prevPrices.isEmpty()) {
            return 0;
        }

        double mean = prevPrices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double dev = prevPrices.stream()
                .mapToDouble(price -> Math.abs(price - mean))
                .average()
                .orElse(0.0);

        return dev > 0 ? 1 : -1;
    }
*/
    
    @Override
    public String toString(){
        return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }
}
