package surJavaAssignment;

public class ForeignStockHolding extends StockHolding {
	
	public float conversionRate;
	ForeignStockHolding(float a, float b, int c, String d, float e)
	{
		super(a ,b, c, d);
		conversionRate = e;
	}
	public float costInDollars(){
		return (purchaseSharePrice * numberOfShares * conversionRate);
	};
	public float valueInDollars(){
		return (currentSharePrice * numberOfShares * conversionRate);
	};
	public float getconversionrate(){
		return this.conversionRate;
	};
}
