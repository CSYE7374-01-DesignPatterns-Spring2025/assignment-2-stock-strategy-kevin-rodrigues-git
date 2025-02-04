package edu.neu.csye7374;

public class MetaStock extends StockAPI{

    public MetaStock(double price) {
        super("Meta", price, "Software Engineering Company");
    }

    public MetaStock(double price, CostStrategy strategy) {
        super("Meta", price, "Social Media Company", strategy);
    }
    
 /*   @Override
    public int getMetric() {
        double mean = this.prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum() / this.prevPrices.size();
        double dev = 0.0;
        for(double num : this.prevPrices) {
            dev += Math.abs(mean - num);
        }
        dev = dev / this.prevPrices.size();
        return dev > 0.0 ? 1 : -1;
    }
*/
    @Override
    public String toString(){
        return "Stock [name: " + this.getName() + ", price: " + this.getPrice() + ", description: " + this.getDescription() + ", Metric: " + this.getMetric() + "]";
    }
}
